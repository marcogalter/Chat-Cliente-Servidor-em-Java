import java.io.IOException;

public class ServidorChat {
    private static final int PORTA = 8080;
    private final GerenciadorClientes gerenciadorClientes = new GerenciadorClientes();
    private UtilidadesServidor utilidadesServidor;

    public void iniciar() throws IOException {
        utilidadesServidor = new UtilidadesServidor(PORTA);
        String ip = utilidadesServidor.getIpServidor();
        System.out.println("Endereço IP do servidor: " + ip);
        System.out.println("Servidor iniciado na porta " + PORTA);

        while (true) {
            ManipuladorConexao manipuladorConexao = new ManipuladorConexao(utilidadesServidor.aceitarConexao());
            String nomeUsuario = manipuladorConexao.receberMensagem();
            Usuario usuario = new Usuario(nomeUsuario, manipuladorConexao);
            gerenciadorClientes.adicionarUsuario(usuario);
            new Thread(() -> manipularCliente(usuario)).start();
        }
    }

    private void manipularCliente(Usuario usuario) {
        String mensagem;
        try {
            while ((mensagem = usuario.getManipuladorConexao().receberMensagem()) != null) {
                gerenciadorClientes.getManipuladorComandos().manipularComando(usuario, mensagem);
                if (mensagem.equalsIgnoreCase("sair")) {
                    break;
                }
            }
        } finally {
            gerenciadorClientes.removerUsuario(usuario);
            usuario.getManipuladorConexao().fechar();
        }
    }

    public static void main(String[] args) {
        try {
            new ServidorChat().iniciar();
        } catch (IOException e) {
            System.out.println("Erro ao iniciar o servidor: " + e.getMessage());
        }
    }
}

