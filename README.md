# Chat Cliente-Servidor em Java

Este projeto é uma aplicação de chat simples, baseada em arquitetura cliente-servidor, desenvolvida em Java. Ele permite que múltiplos clientes se conectem a um servidor central e troquem mensagens entre si. O projeto foi desenvolvido como parte de um trabalho acadêmico e tem como objetivo demonstrar a implementação de sockets, threads, e a manipulação de conexões em rede.

## Funcionalidades

- Conexão de múltiplos clientes a um servidor central.
- Envio de mensagens privadas entre usuários.
- Exibição da lista de usuários conectados ao servidor.
- Comando para desconectar o cliente do servidor.
- Comunicação entre cliente e servidor usando o protocolo TCP/IP.

## Estrutura de Classes

### 1. `ClienteChat.java`
Gerencia a interação do cliente com o servidor. Conecta ao servidor via IP e porta, recebe e envia mensagens. O cliente pode enviar comandos como "exibir" para listar os usuários conectados ou "sair" para desconectar.

### 2. `ServidorChat.java`
Responsável por inicializar o servidor e aceitar conexões dos clientes. Para cada cliente conectado, uma nova thread é criada para tratar a comunicação com o servidor. 

### 3. `GerenciadorClientes.java`
Controla a lista de usuários conectados ao servidor, permitindo a adição e remoção de clientes ativos.

### 4. `ManipuladorComandos.java`
Interpreta os comandos enviados pelos clientes, como o comando "exibir" para mostrar a lista de usuários, ou "sair" para encerrar a conexão.

### 5. `ManipuladorConexao.java`
Gerencia a comunicação entre o cliente/servidor e o socket de conexão. Envia e recebe mensagens através do socket, além de fechar a conexão quando necessário.

### 6. `ManipuladorMensagens.java`
Responsável pelo envio de mensagens entre os clientes conectados e pelo envio da lista de usuários para um cliente solicitante.

### 7. `Usuario.java`
Representa um usuário conectado ao servidor, contendo informações como nome e o manipulador de conexão correspondente.

### 8. `UtilidadesServidor.java`
Gerencia as operações básicas do servidor, como aceitar conexões, fechar o servidor, e obter o endereço IP.

## Como Executar

### Passos para iniciar o servidor:

1. Compile as classes do projeto.
2. Execute a classe `ServidorChat`.
3. O servidor será inicializado e exibirá o IP e a porta no console.

### Passos para iniciar o cliente:

1. Compile as classes do projeto.
2. Execute a classe `ClienteChat`.
3. Insira o IP do servidor e o nome de usuário.
4. Envie mensagens para outros usuários conectados, utilizando o formato `usuario;mensagem`.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Sockets**: Para comunicação entre cliente e servidor.
- **Threads**: Para tratar múltiplos clientes simultaneamente.

## Melhorias Futuras

- Implementar suporte a grupos de chat.
- Adicionar interface gráfica (GUI) com JavaFX ou Swing.
- Criptografar mensagens para maior segurança.
