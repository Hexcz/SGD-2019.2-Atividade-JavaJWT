# SGD-Java-JWT
Exercício da disciplina de Segurança de Dados, cujo proposito é criar uma implementação de autenticação em Java que utilize JWT.

## Aluno
José David Emanoell Feitoza Braga

### Sobre o exercício
Foram utilizados o Glassfish, jdbc,jsp e servlet, além do JWT. Infelizmente o exercício está incompleto, embora eu consiga gerar o token jwt, eu não consigo utilizá-lo e também não implementei o logout e filtros de redirecionamento.

No index.jsp, estão confidos os campos para realizar o login, mas como não há usuários cadastrados, utilizamos o link "cadastre-se" para ser redirecionado para a página de cadastro. Após preencher o formulário, os dados são inseridos no postgreSQL e retornamos para a página index.html. Quando o login é realizado, um token jwt é gerado, porém não tenho ideia de como utilizá-lo, e caso os dados fornecidos batam com os dados no postgreSQL, a aplicação abre o home.jsp, exibindo o nome do usuário logado e um imagem.
