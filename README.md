# Agenda de Contatos MVC com Hibernate e JPA

Bem-vindo à **Agenda de Contatos**, um projeto Java desktop que utiliza o padrão de arquitetura MVC (Model-View-Controller) com Hibernate e JPA para gerenciar uma agenda completa. Este projeto demonstra como criar uma aplicação robusta e escalável, aproveitando as poderosas ferramentas do ecossistema Java.

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Configuração do Ambiente](#configuração-do-ambiente)
- [Execução do Projeto](#execução-do-projeto)
- [Funcionalidades](#funcionalidades)
- [Contribuição](#contribuição)
- [Licença](#licença)

## Sobre o Projeto

Este projeto tem como objetivo criar uma aplicação desktop para gerenciar contatos, usuários, endereços, telefones e profissões. Utilizamos o padrão MVC para separar as responsabilidades da aplicação, tornando-a mais modular e fácil de manter.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Hibernate**: Framework de ORM para mapeamento objeto-relacional.
- **JPA**: Java Persistence API para gerenciar operações de persistência.
- **Swing**: Biblioteca GUI para criar interfaces gráficas.
- **Maven**: Gerenciador de dependências e automação de build.
- **MySQL**: Banco de dados relacional.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

```
AgendaHiberMVC/
│
├── src/main/java/
│   ├── controller/
│   │   ├── ContatoController.java
│   │   ├── UsuarioController.java
│   │   ├── EnderecoController.java
│   │   ├── TelefoneController.java
│   │   └── ProfissaoController.java
│   │
│   ├── dao/
│   │   ├── ContatoDAO.java
│   │   ├── UsuarioDAO.java
│   │   ├── EnderecoDAO.java
│   │   ├── TelefoneDAO.java
│   │   └── ProfissaoDAO.java
│   │
│   ├── modelo/
│   │   ├── Contato.java
│   │   ├── Usuario.java
│   │   ├── Endereco.java
│   │   ├── Telefone.java
│   │   └── Profissao.java
│   │
│   ├── util/
│   │   └── HibernateUtil.java
│   │
│   └── view/
│       ├── MainView.java
│       ├── ContatoView.java
│       ├── UsuarioView.java
│       ├── EnderecoView.java
│       ├── TelefoneView.java
│       └── ProfissaoView.java
│
├── src/main/resources/
│   └── META-INF/
│       └── persistence.xml
│
├── pom.xml
└── README.md
```

## Configuração do Ambiente

1. **Clone o repositório:**

   ```sh
   git clone https://github.com/seu-usuario/AgendaHiberMVC.git
   cd AgendaHiberMVC
   ```

2. **Configuração do Banco de Dados:**

   Crie um banco de dados MySQL com o nome `agenda_contatos`:

  CREATE DATABASE agenda_contatos;

   USE agenda_contatos;

      CREATE TABLE usuario (
          id BIGINT AUTO_INCREMENT PRIMARY KEY,
          nome VARCHAR(255),
          email VARCHAR(255)
      );

      CREATE TABLE endereco (
          id BIGINT AUTO_INCREMENT PRIMARY KEY,
          rua VARCHAR(255),
          numero VARCHAR(50),
          cidade VARCHAR(255),
          estado VARCHAR(255)
      );

      CREATE TABLE telefone (
          id BIGINT AUTO_INCREMENT PRIMARY KEY,
          numero VARCHAR(50)
      );

      CREATE TABLE profissao (
          id BIGINT AUTO_INCREMENT PRIMARY KEY,
          descricao VARCHAR(255)
      );
      
      CREATE TABLE contato (
          id BIGINT AUTO_INCREMENT PRIMARY KEY,
          nome VARCHAR(255),
          email VARCHAR(255),
          usuario_id BIGINT,
          FOREIGN KEY (usuario_id) REFERENCES usuario(id)
      );

3. **Configuração do arquivo `persistence.xml`:**

   Verifique se o arquivo `src/main/resources/META-INF/persistence.xml` está configurado corretamente para se conectar ao seu banco de dados MySQL.

   ```xml
   <persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
                http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
                version="2.1">
       <persistence-unit name="agenda-contatos" transaction-type="RESOURCE_LOCAL">
           <properties>
               <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost/agenda_contatos?useSSL=false&amp;serverTimezone=UTC" />
               <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
               <property name="javax.persistence.jdbc.user" value="root" />
               <property name="javax.persistence.jdbc.password" value="" />
               <property name="hibernate.hbm2ddl.auto" value="update" />
               <property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect" />
               <property name="hibernate.show_sql" value="true" />
               <property name="hibernate.format_sql" value="true" />
           </properties>
       </persistence-unit>
   </persistence>
   ```

4. **Instale as dependências:**

   ```sh
   mvn install
   ```

## Execução do Projeto

1. **Compile e execute a aplicação:**

   ```sh
   mvn exec:java -Dexec.mainClass="view.MainView"
   ```

2. A aplicação será iniciada e você verá a tela principal da Agenda de Contatos.

## Funcionalidades

- **Adicionar, Atualizar e Listar Contatos**
- **Gerenciar Usuários**
- **Cadastrar Endereços**
- **Registrar Telefones**
- **Inserir Profissões**
- **Visualizar Resumo de Todos os Dados**

## Contribuição

Contribuições são bem-vindas! Siga os passos abaixo para contribuir:

1. **Fork o projeto**
2. **Crie uma branch para sua feature (git checkout -b feature/AmazingFeature)**
3. **Commit suas mudanças (git commit -m 'Add some AmazingFeature')**
4. **Push para a branch (git push origin feature/AmazingFeature)**
5. **Abra um Pull Request**

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

Feito com ❤️ por [Reinald Mendes](https://github.com/ReinaldMendes)
```

