public class ManipuladorComandos {
    private final ManipuladorMensagens manipuladorMensagens;

    public ManipuladorComandos(ManipuladorMensagens manipuladorMensagens) {
        this.manipuladorMensagens = manipuladorMensagens;
    }

    public void manipularComando(Usuario usuario, String mensagem) {
        if (mensagem.equalsIgnoreCase("sair")) {
            usuario.getManipuladorConexao().fechar();
        } else if (mensagem.equalsIgnoreCase("exibir")) {
            manipuladorMensagens.enviarListaUsuarios(usuario);
        } else {
            String[] partes = mensagem.split(";", 2);
            if (partes.length == 2) {
                manipuladorMensagens.enviarMensagemParaCliente(partes[0], partes[1], usuario.getNome());
            }
        }
    }
} 
    

