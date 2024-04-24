# Auth API
API de autenticação com Spring Boot, H2 database e utilizando JSON Web Token.
## Funcionalidades
- Cadastro do usuário
- Login do usuário
## Como usar
1. Certifique-se de ter o Java 17 instalado
   ```
    java --version
    ```
    Caso não tenha o Java instalado, poderá baixá-lo em https://www.oracle.com/br/java/technologies/downloads/
2. Clone o repositório do GitHub  
   Abra o terminal e navegue para o diretório onde você deseja que o projeto seja clonado. Em seguida, execute o comando git clone seguido pela URL do repositório do GitHub:

   ```
   git clone https://github.com/JeielLucas/Auth-Api.git
   ```
3. Navegue para o Diretório do Projeto  
    Use o comando cd para entrar no diretório do projeto que você acabou de clonar:
    ```
    cd ./Auth-Api
    ```
4. Instale as dependências  
    Dentro do diretório do projeto, execute o comando mvn clean install para instalar as dependências listadas no arquivo pom.xml:
    ```
    mvn clean install
    ```
 5. Inicie o projeto com Maven  
 Agora que você tem as dependências instaladas, pode usar o Maven para iniciar o projeto. Maven é uma ferramenta de automação de compilação utilizada primariamente para projetos Java, mas também pode ser usado para construir e gerenciar projetos em outras linguagens. Execute o seguinte comando:
    ```
    mvn spring-boot:run
    ```
6. Acesse a api em http://localhost:8080

## Rotas da aplicação
### POST /auth/register
Rota para registro do usuário, com o seguinte body na requisição:
```json
{
	"name": "Nome do usuário",
	"email": "Email",
	"password": "Senha",
	"role": "Tipo de usuário (ADMIN ou USER)"
}
```
### POST /auth/login
Rota para login do usuário, com o seguinte body na requisição:
```json
{
	"email": "Email",
	"password": "Senha"
}
```
### GET /auth/users
Retorna todos os usuários cadastrados, com os dados de: Id, Name, Email, Password e Role
