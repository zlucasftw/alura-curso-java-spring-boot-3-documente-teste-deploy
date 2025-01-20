# Med Voll API 🏥

<div align="center">

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![Jakarta EE](https://img.shields.io/badge/Jakarta_EE-ED8B00?style=for-the-badge&logo=javaee&logoColor=white)](https://jakarta.ee/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white)](https://spring.io/projects/spring-security)
[![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-data-jpa)
[![Flyway](https://img.shields.io/badge/Flyway-CC0200?style=for-the-badge&logo=flyway&logoColor=white)](https://flywaydb.org/)
[![JUnit](https://img.shields.io/badge/JUnit-25A162?style=for-the-badge&logo=junit5&logoColor=white)](https://junit.org/junit5/)
[![Mockito](https://img.shields.io/badge/Mockito-25A162?style=for-the-badge&logo=mockito&logoColor=white)](https://site.mockito.org/)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org/)
[![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white)](https://www.jetbrains.com/idea/)
[![Insomnia](https://img.shields.io/badge/Insomnia-5849BE?style=for-the-badge&logo=insomnia&logoColor=white)](https://insomnia.rest/)
[![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)](https://swagger.io/)

</div>

[Clique aqui para acessar o README PT-BR](README-PT-BR.md)

## 📋 Description

Med Voll API is a robust healthcare management system built with Java and Spring Boot 3. This project was developed as part of the course "Spring Boot 3: Document, Test, and Prepare an API for Deployment". It provides comprehensive functionality for managing patients, doctors, and medical appointments, offering seamless operations for registration, listing, updating, and deletion of records.


## 🛠️ Technologies

- **Java**: Core programming language
- **Jakarta Validation**: Data validation
- **Spring Boot 3**: Latest version of the application framework
- **Spring Data JPA**: Database operations
- **Spring Security**: Authentication and authorization
- **Flyway**: Database migration tool
- **Maven**: Dependency management and build automation
- **MySQL**: Database management system
- **Swagger**: API documentation
- **IntelliJ IDEA**: Integrated development environment
- **Insomnia**: API testing and development tool

## 📁 Project Structure

```
src/main/java/med/voll/api/
├── controller/     # API endpoints
├── domain/        # Business logic and repositories
└── infra/         # Configurations and infrastructure
```

## 🔄 API Endpoints

### 👤 Patients

| Method | Endpoint | Description |
|:------:|----------|-------------|
| ![POST](https://img.shields.io/badge/-POST-4CAF50?style=for-the-badge&logo=post&logoColor=white&labelColor=4CAF50&logoWidth=0) | `/pacientes` | Register new patient |
| ![GET](https://img.shields.io/badge/-GET-2196F3?style=for-the-badge&logo=get&logoColor=white&labelColor=2196F3&logoWidth=0) | `/pacientes` | List active patients |
| ![GET](https://img.shields.io/badge/-GET-2196F3?style=for-the-badge&logo=get&logoColor=white&labelColor=2196F3&logoWidth=0) | `/pacientes/{id}` | Get patient details |
| ![PUT](https://img.shields.io/badge/-PUT-FFA000?style=for-the-badge&logo=put&logoColor=white&labelColor=FFA000&logoWidth=0) | `/pacientes` | Update patient info |
| ![DELETE](https://img.shields.io/badge/-DELETE-F44336?style=for-the-badge&logo=delete&logoColor=white&labelColor=F44336&logoWidth=0) | `/pacientes/{id}` | Deactivate patient |

### 👨‍⚕️ Doctors

| Method | Endpoint | Description |
|:------:|----------|-------------|
| ![POST](https://img.shields.io/badge/-POST-4CAF50?style=for-the-badge&logo=post&logoColor=white&labelColor=4CAF50&logoWidth=0) | `/medicos` | Register new doctor |
| ![GET](https://img.shields.io/badge/-GET-2196F3?style=for-the-badge&logo=get&logoColor=white&labelColor=2196F3&logoWidth=0) | `/medicos` | List active doctors |
| ![GET](https://img.shields.io/badge/-GET-2196F3?style=for-the-badge&logo=get&logoColor=white&labelColor=2196F3&logoWidth=0) | `/medicos/{id}` | Get doctor details |
| ![PUT](https://img.shields.io/badge/-PUT-FFA000?style=for-the-badge&logo=put&logoColor=white&labelColor=FFA000&logoWidth=0) | `/medicos` | Update doctor info |
| ![DELETE](https://img.shields.io/badge/-DELETE-F44336?style=for-the-badge&logo=delete&logoColor=white&labelColor=F44336&logoWidth=0) | `/medicos/{id}` | Remove doctor |

### 📅 Appointments

| Method | Endpoint | Description |
|:------:|----------|-------------|
| ![POST](https://img.shields.io/badge/-POST-4CAF50?style=for-the-badge&logo=post&logoColor=white&labelColor=4CAF50&logoWidth=0) | `/consultas` | Schedule appointment |
| ![DELETE](https://img.shields.io/badge/-DELETE-F44336?style=for-the-badge&logo=delete&logoColor=white&labelColor=F44336&logoWidth=0) | `/consultas` | Cancel appointment |

## 📚 API Documentation

Access the API documentation through Swagger. Configuration example:

```java
@Configuration
public class SpringDocConfigurations {
    
    @Bean
    public OpenAPI customerOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                    .type(SecurityScheme.Type.HTTP)
                                    .scheme("bearer")
                                    .bearerFormat("JWT")));
    }
}
```

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven
- MySQL Server
- IntelliJ IDEA (recommended) or your preferred IDE

### Spring Initializr

To quickly set up the project using Spring Initializr:

1. Go to [Spring Initializr](https://start.spring.io/)
2. Select the following options:
    - **Project**: Maven Project
    - **Language**: Java
    - **Spring Boot**: 3.0.0 (or the latest stable version)
    - **Project Metadata**:
        - **Group**: `med.voll`
        - **Artifact**: `api`
        - **Name**: `medvoll-api`
        - **Package Name**: `med.voll.api`
        - **Packaging**: Jar
        - **Java**: 17+
3. Add the following dependencies:
    - Spring Web
    - Spring Data JPA
    - Spring Security
    - MySQL Driver
    - Flyway Migration
    - Spring Boot DevTools
4. Click on **Generate** to download the project as a zip file.
5. Extract the zip file and open it in IntelliJ IDEA.

### Database Setup

1. Create a MySQL database for the project
2. Create a `.env` file in the project root with the following variables:
```properties
DB_ADDRESS=YOUR_DATABASE_ADDRESS
DB_NAME=YOUR_DATABASE_NAME
DB_USER=YOUR_DATABASE_USER
DB_PASSWORD=YOUR_DATABASE_PASSWORD
JWT_SECRET=YOUR_JWT_SECRET
```

### Application Properties

The project uses the following configuration in `application.properties`:
```properties
spring.config.import=file:.env[.properties]

spring.datasource.url=jdbc:mysql://${DB_ADDRESS}/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.error.include-stacktrace=never

api.security.token.secret=${JWT_SECRET:12345678}
```

### Installation Steps

1. Clone the repository:
```bash
git clone https://github.com/zlucasftw/alura-curso-java-spring-boot-3-documente-teste-deploy.git
```

2. Navigate to project directory:
```bash
cd alura-curso-java-spring-boot-3-documente-teste-deploy
```

3. Create and configure the `.env` file as described above

4. Run the application:
```bash
mvn spring-boot:run
```

The application will start and Flyway will automatically run the database migrations.

### Verifying the Installation

1. The application will be available at `http://localhost:8080`
2. Access the Swagger documentation at `http://localhost:8080/swagger-ui.html`
3. Test the endpoints using Insomnia or your preferred API testing tool

## 🤝 Contributing

Contributions are welcome! Feel free to:
- Open issues
- Submit pull requests
- Suggest improvements

## 📄 License

This project is licensed under the AGPL V3 License - see the [LICENSE](LICENSE) file for details.

---
<div align="center">
Part of the course "Spring Boot 3: Document, Test, and Prepare an API for Deployment"
</div>
