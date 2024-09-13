import java.util.List;

public class ManipuladorMensagens {
    private final List<Usuario> usuarios;

    public ManipuladorMensagens(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void enviarMensagemParaCliente(String nomeUsuario, String mensagem, String nomeRemetente) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nomeUsuario)) {
                usuario.getManipuladorConexao().enviarMensagem("Mensagem de " + nomeRemetente + ": " + mensagem);
                break;
            }
        }
    }

    public void enviarListaUsuarios(Usuario solicitante) {
        solicitante.getManipuladorConexao().enviarMensagem("----Lista de Usuários----");
        for (Usuario usuario : usuarios) {
            solicitante.getManipuladorConexao().enviarMensagem(usuario.getNome());
        }
    }
}

