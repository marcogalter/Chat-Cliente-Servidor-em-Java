import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class UtilidadesServidor {
    private final ServerSocket serverSocket;

    public UtilidadesServidor(int porta) throws IOException {
        this.serverSocket = new ServerSocket(porta);
    }

    public Socket aceitarConexao() throws IOException {
        return serverSocket.accept();
    }

    public void fechar() throws IOException {
        serverSocket.close();
    }

    public String getIpServidor() throws IOException {
        return InetAddress.getLocalHost().getHostAddress();
    }
} 
    

