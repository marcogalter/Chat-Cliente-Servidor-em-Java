public class Usuario {
        private final String nome;
        private final ManipuladorConexao manipuladorConexao;
    
        public Usuario(String nome, ManipuladorConexao manipuladorConexao) {
            this.nome = nome;
            this.manipuladorConexao = manipuladorConexao;
        }
    
        public String getNome() {
            return nome;
        }
    
        public ManipuladorConexao getManipuladorConexao() {
            return manipuladorConexao;
        }
    }

