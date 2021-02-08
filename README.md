# Teste Builders by Marcelo Anderson

 Neste repositório se encontra um REST API de Clientes que permite salvar, alterar 

 Antes mesmo de começar é necessário ter instalado no seu ambiente:
 
  [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
  
  [Docker](https://www.docker.com/products/docker-desktop)

 [Maven](https://maven.apache.org)
 
 # Assim como solicitado segue o link do Postman das requisições.
 
https://www.getpostman.com/collections/e0b06c479c854b94eb61

# Primeiro passo

 O primeiro passo para subir seu projeto é ultilizar do docker para ter seu banco de dados. Já está tudo preparado no projeto com o init.sql adicionando um aluno na inicialização.
 
 Entre com a linha de comando na pasta do projeto com o docker no ar e digite: docker-compose up postgres.
 
 Com este comando vai iniciar seu banco de dados Postgres(escolhi Postgres pois é o que eu tenho maior dominio e familiaridade.) e estará pronto para usar o projeto.
 
# Segundo passo

  Apos isso dê start no projeto spring com o comando:
 
  mvnw spring-boot:run
 
  Aconselho ultilizar o InteliJ para subir o ambiente pois ele facilita muita coisa.

# Ultimo passo

 Agora é só criar editar excluir os clientes a vontade usando o postman :)
