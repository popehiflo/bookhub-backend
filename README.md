# BookHub: Sistema de Gestion de Biblioteca 📚
**Proyecto Web Fullstack**  
*Proyecto de tipo comercio electronico, especificamente una Tienda Online de Libros donde el usuario podra realizar la compra y posterior pago usando la API de Paypal.*   
`H2`, `PostgreSQL`, `JPA`, `Hibernate`, `Spring Boot`, `Spring Data JPA`, `Spring MVC`, `Spring Security`, `JWT`, `HTML`, `CSS`, `TypeScript`, `Angular`.
## Repositorios del proyecto 📁
* ### [BookHub-backend](https://github.com/popehiflo/bookhub-backend) 📌
* ### [BookHub-frontend](https://github.com/popehiflo/ebook-online-frontend)

## Backend Java 🛠️
*API Rest usando Java con Spring Boot 3.1.4 y base de datos H2/PostgreSQL. Uso de JPA con Hibernate para la persistencia de datos. También tiene validación de datos, manejo de excepciones, uso adecuado del protocolo HTTP en estándar REST y mucho más*
* [H2](https://www.h2database.com/html/main.html) - Base de Datos relacionales hecho con Java SQL
* [PostgreSQL 15](https://dev.mysql.com/downloads/mysql/) - RDBMS de codigo abierto
* [Java 17](https://www.oracle.com/java/technologies/downloads/#java17) - Java SE Development Kit 17
* [Spring](https://spring.io/) - El framework web mas usado
    * [Spring Boot]()
    * [Spring Data JPA]()
    * [Spring MVC]()
    * [Spring Security]()
* [Maven](https://maven.apache.org/) - Manejador de dependencias

## Ejecutando localmente 🚀
Esta es una aplicación [Spring Boot](https://spring.io/guides/gs/spring-boot/) construida usando [Maven](https://spring.io/guides/gs/maven/). Se puede compilar y ejecutar desde la línea de comandos:
```
... despues de clonar el repositorio
cd bookhub-backend
mvn spring-boot:run
``` 
Luego navegar hacia `http://localhost:8080/`  
Recuerda revisar el archivo [application.properties](src/main/resources/application.properties) para ver el puerto en uso, activar el perfil y según eso que gestor de base de datos usara.
## Postman 📎
Colección de requests [Collection Service Orders](https://www.getpostman.com/collections/1abd828e2e340b18f803) que puedes descargar e importar en tu cliente Postman.
Se lista los distintos endpoints de la API. Tiene variables de entorno (URL_BASE, TOKEN).
## Descripción 💬
API REST que permite el CRUD de la diferentes Entidades aqui listadas:
- [Area](src/main/java/io/github/popehiflo/bookhub/model/Area.java): Areas al cual pertenece el libro
- [SubArea](src/main/java/io/github/popehiflo/bookhub/model/SubArea.java): SubArea del algun Area
- [Editorial](src/main/java/io/github/popehiflo/bookhub/model/Editorial.java): Editorial
- [Autor](src/main/java/io/github/popehiflo/bookhub/model/Autor.java): Autor del libro
- [Zona](src/main/java/io/github/popehiflo/bookhub/model/Zona.java): Zona
- [Ejemplar](src/main/java/io/github/popehiflo/bookhub/model/Ejemplar.java): Ejemplar del libro

## Si encuentra un error o quiere sugerir una mejora 📧
Siéntase libre de informar algun problema aquí:
[https://github.com/popehiflo/bookhub-backend/issues](https://github.com/popehiflo/bookhub-backend/issues)
## Licencia 📄
¿Qué es eso? 😆


⌨️ con ❤️ por [popehiflo](https://github.com/popehiflo) 😊