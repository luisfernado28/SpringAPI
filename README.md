# API for users using Spring

Spring Boot REST API for user management.

Links to key sources
- [`com.luisapi.userApi.UserApiApplication`](src/main/java/com/luisapi/userApi/UserApiApplication.java) — application entry.
- [`com.luisapi.userApi.UserController`](src/main/java/com/luisapi/userApi/UserController.java) — REST endpoints.
- [`com.luisapi.userApi.Services.UserService`](src/main/java/com/luisapi/userApi/Services/UserService.java) — business logic.
- [`com.luisapi.userApi.Repository.UserRepository`](src/main/java/com/luisapi/userApi/Repository/UserRepository.java) — JPA repository.
- [`com.luisapi.userApi.Models.User`](src/main/java/com/luisapi/userApi/Models/User.java) — JPA entity.
- [`com.luisapi.userApi.config.SecurityConfig`](src/main/java/com/luisapi/userApi/config/SecurityConfig.java) — basic security config (H2 console allowed).
- [`com.luisapi.userApi.config.SwaggerConfig`](src/main/java/com/luisapi/userApi/config/SwaggerConfig.java) — OpenAPI info.
- [src/main/resources/application.properties](src/main/resources/application.properties) — app and H2 config.
- [src/main/resources/static/index.html](src/main/resources/static/index.html) — example static page.
- [pom.xml](pom.xml) — build configuration.
- [src/test/java/com/luisapi/userApi/UserApiApplicationTests.java](src/test/java/com/luisapi/userApi/UserApiApplicationTests.java) — basic test.

Tech stack
- Java 21
- Spring Boot 4
- Spring Web, Spring Data JPA, Spring Security
- H2 in-memory database
- springdoc OpenAPI (Swagger UI)

Quickstart

1. Build and run (Linux / macOS)
   ./mvnw spring-boot:run

   Windows (PowerShell / CMD)
   ./mvnw.cmd spring-boot:run

2. App runs on http://localhost:8080 by default.

Database console
- H2 console: http://localhost:8080/h2-console
  - JDBC URL configured in [application.properties](src/main/resources/application.properties) as `jdbc:h2:mem:userdb`.

API docs (OpenAPI / Swagger)
- Swagger UI: http://localhost:8080/swagger-ui.html (springdoc default)
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
- Persistence uses H2 in-memory; data is volatile between restarts.
- Validation annotations are defined on [`com.luisapi.userApi.Models.User`](src/main/java/com/luisapi/userApi/Models/User.java) (`@NotBlank`, `@Email`).
- Security is minimal and configured to allow H2 console access in [`com.luisapi.userApi.config.SecurityConfig`](src/main/java/com/luisapi/userApi/config/SecurityConfig.java).
