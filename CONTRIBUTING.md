# Guía de Contribución para BookHub

¡Gracias por tu interés en contribuir a BookHub! Para asegurar un desarrollo coherente y de alta calidad, por favor
sigue las siguientes guías.

## Flujo de Trabajo con Git

Utilizamos un flujo de trabajo basado en ramas de funcionalidad (`feature branches`).

1. **Crea una Rama:** Nunca trabajes directamente sobre `main` o `dev`. Crea una rama a partir de la rama `dev`.

    - Para nuevas funcionalidades: `feat/<nombre-funcionalidad>` (e.g., `feat/gestion-libros`)
    - Para corrección de errores: `fix/<nombre-bug>` (e.g., `fix/error-login`)

2. **Realiza Commits:** Haz commits atómicos y con mensajes claros, siguiendo la convención
   de [Commits Convencionales](https://www.conventionalcommits.org/en/v1.0.0/).

3. **Envía un Pull Request (PR):** Cuando tu trabajo esté completo, envía un Pull Request de tu rama hacia `dev`.
   Asegúrate de que tu código compila y pasa cualquier prueba existente.

## Convenciones de Commits

Seguimos la especificación de [Commits Convencionales](https://www.conventionalcommits.org/en/v1.0.0/). Los mensajes de
commit deben seguir este formato:

```
<tipo>: <descripción>
[cuerpo opcional]
[pie opcional]
```

### Tipos permitidos:

- `feat`: Nueva funcionalidad
- `fix`: Corrección de errores
- `docs`: Cambios en documentación
- `style`: Cambios de formato (que no afectan el código)
- `refactor`: Refactorización de código
- `test`: Añadir o modificar tests
- `chore`: Cambios en el proceso de build o herramientas auxiliares

### Ejemplos:

- `feat: agregar endpoint para búsqueda de libros por autor`
- `fix: corregir validación de ISBN en registro de libros`
- `docs: actualizar README con instrucciones de Docker`

## Migraciones de Base de Datos con Flyway

La gestión del schema de la base de datos es una parte crítica del proyecto.

### Nomenclatura de Scripts

Para evitar conflictos en un entorno de desarrollo con múltiples colaboradores, utilizamos un sistema de versiones
basado en **timestamp**.

El formato es: `V<YYYYMMDDHHMMSS>__Descripcion_corta_en_snake_case.sql`

- **Ejemplo:** `V20250920153000__agregar_tabla_libros.sql`

Esto asegura que cada migración tenga un número de versión único y secuencial en el tiempo, sin importar quién la haya
creado.

### La Regla de Oro de las Migraciones

> **UNA VEZ QUE UNA MIGRACIÓN HA SIDO APLICADA EN CUALQUIER ENTORNO (INCLUYENDO TU MÁQUINA LOCAL), NO DEBE SER
MODIFICADA NUNCA.**

- Si cometiste un error en una migración ya aplicada, **crea una nueva migración** que corrija el problema.
- Si necesitas revertir un cambio, **crea una nueva migración** que revierta dicho cambio.

Modificar una migración existente después de que ha sido aplicada corromperá el historial de Flyway en las máquinas de
otros desarrolladores y en los entornos de despliegue, causando fallos graves.

## Proceso de Review de Código

### Antes de crear un Pull Request:

1. **Asegúrate de que tu código compile:**
    ```bash
    mvn clean compile
    ```
2. Ejecuta las pruebas:
    ```bash
    mvn test
    ```
3. Actualiza tu rama con los últimos cambios de dev:

    ```bash
    git checkout dev
    git pull origin dev
    git checkout tu-rama
    git merge dev
    ```

### Checklist para Pull Requests:

- ✅ Los commits siguen las convenciones establecidas
- ✅ Las migraciones de Flyway siguen la nomenclatura correcta
- ✅ Se han añadido/actualizado las pruebas necesarias
- ✅ La documentación está actualizada si es necesario


