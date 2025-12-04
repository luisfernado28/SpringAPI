# API for users using Spring

Spring Boot REST API for user management.

Links to key sources
- [`com.luisapi.userApi.UserApiApplication`](src/main/java/com/luisapi/userApi/UserApiApplication.java) — application entry.
- [`com.luisapi.userApi.UserController`](src/main/java/com/luisapi/userApi/UserController.java) — REST endpoints.
- [`com.luisapi.userApi.Services.UserService`](src/main/java/com/luisapi/userApi/Services/UserService.java) — business logic.
- [`com.luisapi.userApi.Repository.UserRepository`](src/main/java/com/luisapi/userApi/Repository/UserRepository.java) — JPA repository.
- [`com.luisapi.userApi.Models.User`](src/main/java/com/luisapi/userApi/Models/User.java) — JPA entity.
- [`com.luisapi.userApi.config.SecurityConfig`](src/main/java/com/luisapi/userApi/config/SecurityConfig.java) — basic security config.
- [`com.luisapi.userApi.config.SwaggerConfig`](src/main/java/com/luisapi/userApi/config/SwaggerConfig.java) — OpenAPI info.
- [src/main/resources/application.properties](src/main/resources/application.properties) — app and profile config.
- [src/main/resources/application-dev.properties](src/main/resources/application-dev.properties) — dev datasource (env-driven).
- [src/main/resources/static/index.html](src/main/resources/static/index.html) — example static page.
- [pom.xml](pom.xml) — build configuration.
- [src/test/java/com/luisapi/userApi/UserApiApplicationTests.java](src/test/java/com/luisapi/userApi/UserApiApplicationTests.java) — basic test.

Tech stack
- Java 21
- Spring Boot 4
- Spring Web, Spring Data JPA, Spring Security
- PostgreSQL (run via Docker Compose) — no longer using H2
- springdoc OpenAPI (Swagger UI)

Quickstart

1. Build and run (Linux / macOS)
   ./mvnw spring-boot:run

   Windows (PowerShell / CMD)
   ./mvnw.cmd spring-boot:run

2. App runs on http://localhost:8080 by default.

Database (updated)
- This project now uses PostgreSQL as the primary datastore (configured via Spring properties and environment variables).
- H2 is no longer used by the application. If present, H2 may remain for legacy tests but the running app expects Postgres.
- Configuration sources:
  - application.properties controls active profile (default: dev)
  - application-dev.properties reads datasource values from environment variables:
    - SPRING_DATASOURCE_URL
    - SPRING_DATASOURCE_USERNAME
    - SPRING_DATASOURCE_PASSWORD

Docker / Docker Compose
- A docker-compose.yml is provided to run Postgres and the app together. When running in Docker make sure JDBC host points to the compose service name (postgres), not localhost.
- Example .env (project root) configures Postgres and app envs:
  - SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/userdb
  - SPRING_DATASOURCE_USERNAME=u
  - SPRING_DATASOURCE_PASSWORD=p
  - POSTGRES_DB=userdb
  - POSTGRES_USER=u
  - POSTGRES_PASSWORD=p

API docs (OpenAPI / Swagger)
- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs

Main endpoints (from [`com.luisapi.userApi.UserController`](src/main/java/com/luisapi/userApi/UserController.java))
- GET /users — list users
- GET /users/{id} — get user by id
- POST /users — create user (JSON body)
- PUT /users/{id} — update user
- DELETE /users/{id} — delete user
- GET /users/status — health / example endpoint

Example curl
- Create:
  curl -X POST -H "Content-Type: application/json" -d '{"name":"Alice","email":"a@example.com"}' http://localhost:8080/users
- List:
  curl http://localhost:8080/users

Testing
- Run unit tests:
  ./mvnw test

Notes
- The app uses PostgreSQL by default when run in Docker or with the appropriate SPRING_DATASOURCE_* env vars.
- For development you can run Postgres via docker-compose:
  docker-compose up --build
- Replace spring.jpa.hibernate.ddl-auto=update with a migration tool (Flyway/Liquibase) for production.
