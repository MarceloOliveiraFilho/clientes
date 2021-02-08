# Teste Builders by Marcelo Anderson

 Neste repositório se encontra um REST API de Clientes que permite salvar, alterar 

 Antes mesmo de começar é necessário ter instalado no seu ambiente:
 
  [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
  
  [Docker](https://www.docker.com/products/docker-desktop)

 [Maven](https://maven.apache.org)
 
 # Assim como solicitado segue o link do Postman das requisições.
 
https://www.getpostman.com/collections/e0b06c479c854b94eb61
detalhe:
 Foi feito um desafio para hospedar em algum lugar e eu fiz isso com a amazon.
 Se quiser apenas usar o link tricar de localhost na colection para ec2-52-14-1-68.us-east-2.compute.amazonaws.com:8080/cliente.

# Primeiro passo

 O primeiro passo para subir seu projeto é utilizar do Docker para ter seu banco de dados. Já está tudo preparado no projeto com o init.sql adicionando um aluno na inicialização.
 
 Entre com a linha de comando na pasta do projeto com o Docker no ar e digite: docker-compose up postgres.
 
 Com este comando vai iniciar seu banco de dados Postgres(escolhi Postgres, pois é o que eu tenho maior domínio e familiaridade.) e estará pronto para usar o projeto.
 
# Segundo passo

  Apos isso dê start no projeto spring com o comando:
 
  mvnw spring-boot:run
 
  Aconselho ultilizar o InteliJ para subir o ambiente, pois ele facilita muita coisa.

# Ultimo passo

 Agora é só editar, excluir ou consultar os clientes a vontade usando o postman :)

é possível fazer as seguintes requisições:


(POST) Inserir cliente

(GET) Pesquisar todos os clientes

(DEL) Delete cliente por ID

(PATCH) Atualizar cliente

(GET) Pesquisar por nome

(GET) Pesquisar por idade

(GET) Pesquisar por cpf

(GET) Consulta de clientes paginada
