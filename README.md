# BookHub 📚
Proyecto de tipo comercio electronico, especificamente una Tienda Online de Libros donde el usuario podra realizar la compra y posterior pago usando la API de Paypal.

`H2`, `PostgreSQL`, `Maven`, `JPA`, `Hibernate`, `Spring Boot`, `Spring Data JPA`, `Spring MVC`, `Spring Security`, `JWT`, `HTML`, `CSS`, `TypeScript`, `Angular`.

## Repositorios del proyecto 📁
* ### [BookHub-backend](https://github.com/popehiflo/bookhub-backend) 📌
* ### [BookHub-frontend](https://github.com/popehiflo/bookhub-frontend)

## Estructura de Proyecto 📦

## Requisitos Previos

Asegúrate de tener instalado el siguiente software en tu máquina:

- [Java JDK 21](https://www.oracle.com/java/technologies/downloads/#jdk21-windows) o superior.
- [Apache Maven](https://maven.apache.org/download.cgi) 3.8 o superior.
- [Docker](https://www.docker.com/products/docker-desktop/) y Docker Compose.
- Tu IDE de preferencia (e.g., IntelliJ IDEA).

## Configuración Inicial

Sigue estos pasos para configurar el entorno de desarrollo en tu máquina local.

### 1. Clonar el Repositorio

```bash
  git clone git@github.com:popehiflo/bookhub-backend.git
  cd bookhub-backend
```

### 2. Configurar Variables de Entorno

Este proyecto usa un archivo `.env` para gestionar las credenciales de la base de datos local, gracias a la dependencia `spring-boot-dotenv`.

- Crea una copia del archivo `.env.example` y renómbrala a `.env`.
- El archivo `.env` ya viene pre-configurado con valores para el entorno de Docker. No necesitas cambiar nada para empezar, pero puedes ajustar el puerto (`POSTGRES_PORT`) si `5436` está en uso en tu máquina.

**Importante:** El archivo `.env` está ignorado por Git (`.gitignore`) y nunca debe ser subido al repositorio.

### 3. Levantar la Base de Datos

Usa Docker Compose para iniciar el contenedor de la base de datos PostgreSQL.

```bash
  docker-compose up -d
```

- El comando `-d` (detached) ejecuta el contenedor en segundo plano.
- La primera vez que se ejecute, Docker descargará la imagen de PostgreSQL 16 y creará una base de datos llamada
  `bookhub_db` con un usuario propietario `bookhub_owner`.
- Los datos de la base de datos persistirán en un volumen de Docker llamado `bookhub-postgres-data`.

## Flujo de Trabajo de Desarrollo

Para una guía detallada sobre el flujo de Git, la nomenclatura de commits y las convenciones del proyecto, consulta
nuestra **[Guía de Contribución](CONTRIBUTING.md)**.

### Ejecutar la Aplicación

Una vez que la base de datos esté corriendo en Docker, puedes iniciar la aplicación de Spring Boot:

- **Desde tu IDE:** Busca la clase `Application` y ejecútala directamente.
- **Desde la terminal (usando Maven):**

```bash
  mvn spring-boot:run
```

Al iniciar, **Flyway** se activará automáticamente:

1. Se conectará a la base de datos.
2. Revisará el schema `dbo`.
3. Ejecutará las migraciones pendientes que se encuentren en `src/main/resources/db/migration`.

### Crear Nuevas Migraciones

Cuando necesites hacer un cambio en la estructura de la base de datos (crear una tabla, añadir una columna, etc.):

1. Crea un nuevo archivo en `src/main/resources/db/migration`.
2. Nombra el archivo siguiendo la convención de timestamp del proyecto:
   `V<YYYYMMDDHHMMSS>__<DESCRIPCION_EN_SNAKE_CASE>.sql`. Por ejemplo: `V20250920213000__crear_tabla_autores.sql`.
3. Escribe tus sentencias SQL en el archivo.
4. Inicia la aplicación. Flyway aplicará el nuevo script automáticamente.

## Perfiles de Configuración

El proyecto utiliza perfiles de Spring para gestionar la configuración de cada entorno.

- **`dev` (desarrollo):** Es el perfil por defecto. Se activa automáticamente y carga la configuración desde
  `application-dev.properties`, que está preparada para conectarse a la base de datos de Docker.
- **`prod` (producción):** Contiene la configuración para el despliegue en producción (`application-prod.properties`).
  Espera que las credenciales y la URL de la base de datos sean proporcionadas como variables de entorno en el servidor.
  Para activarlo, se debe iniciar la aplicación con el argumento `--spring.profiles.active=prod`.
- **`test` (testing):** Se activa automáticamente al ejecutar las pruebas (e.g., `mvn test`). Carga la configuración desde
  `src/test/resources/application-test.properties`, que configura una base de datos en memoria (H2) para asegurar que
  las pruebas sean rápidas y aisladas del entorno de desarrollo.

## Solución de Problemas (Troubleshooting)

### Error: `password authentication failed`

Este error ocurre si la base de datos en Docker se inició con credenciales diferentes a las que están en tu archivo
`.env` actual. Para solucionarlo, necesitas forzar una reinicialización completa de la base de datos.

**Advertencia:** Esto eliminará todos los datos de tu base de datos local.

1. **Detener y eliminar los contenedores:**
   ```bash
   docker-compose down
   ```

2. **Eliminar el volumen de datos:**
   ```bash
   docker volume rm bookhub-backend_bookhub-postgres-data
   ```

3. **Iniciar los servicios de nuevo:**
   ```bash
   docker-compose up -d
   ```

Después de estos pasos, la base de datos se creará desde cero con las credenciales más recientes de tu archivo `.env`.

## Licencia 📄

⌨️ con ❤️ por [popehiflo](https://github.com/popehiflo) 😊