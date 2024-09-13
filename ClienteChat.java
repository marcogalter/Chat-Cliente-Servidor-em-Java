import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteChat implements Runnable {
    private ManipuladorConexao manipuladorConexao;
    private final Scanner scanner = new Scanner(System.in);

    public void iniciar() throws IOException {
        System.out.println("Digite o IP do servidor:");
        String ipServidor = scanner.nextLine();
        manipuladorConexao = new ManipuladorConexao(new Socket(ipServidor, 8080));

        System.out.println("Conectado ao servidor em " + ipServidor);
        System.out.println("Digite seu nome de usuário:");
        String nomeUsuario = scanner.nextLine();
        manipuladorConexao.enviarMensagem(nomeUsuario);

        mostrarInstrucoes();
        new Thread(this).start();
        loopMensagens();
    }

    private void mostrarInstrucoes() {
        System.out.println("Instruções:");
        System.out.println("Comando 'exibir' = mostra todos os usuários");
        System.out.println("Enviar mensagem = usuário;mensagem (ex: user;olá)");
        System.out.println("Para sair = digite 'sair'");
    }

    @Override
    public void run() {
        String mensagem;
        while ((mensagem = manipuladorConexao.receberMensagem()) != null) {
            System.out.println(mensagem);
        }
    }

    private void loopMensagens() throws IOException {
        String mensagem;
        do {
            mensagem = scanner.nextLine();
            manipuladorConexao.enviarMensagem(mensagem);
        } while (!mensagem.equalsIgnoreCase("sair"));

        manipuladorConexao.fechar();
    }

    public static void main(String[] args) {
        try {
            new ClienteChat().iniciar();
        } catch (IOException e) {
            System.out.println("Erro ao iniciar cliente: " + e.getMessage());
        }
    }
}

