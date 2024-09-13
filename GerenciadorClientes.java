import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GerenciadorClientes {
    private final List<Usuario> usuarios = new CopyOnWriteArrayList<>();
    private final ManipuladorMensagens manipuladorMensagens;
    private final ManipuladorComandos manipuladorComandos;

    public GerenciadorClientes() {
        manipuladorMensagens = new ManipuladorMensagens(usuarios);
        manipuladorComandos = new ManipuladorComandos(manipuladorMensagens);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void removerUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public ManipuladorComandos getManipuladorComandos() {
        return manipuladorComandos;
    }
} 
    
