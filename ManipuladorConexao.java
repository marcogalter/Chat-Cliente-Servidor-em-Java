import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ManipuladorConexao {
    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;

    public ManipuladorConexao(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void fechar() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }

    public String receberMensagem() {
        try {
            return in.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean enviarMensagem(String mensagem) {
        out.println(mensagem);
        return !out.checkError();
    }
}


