# Med Voll API 🏥

<div align="center">

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org/)
[![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Flyway](https://img.shields.io/badge/Flyway-CC0200?style=for-the-badge&logo=flyway&logoColor=white)](https://flywaydb.org/)
[![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)](https://swagger.io/)
[![Jakarta EE](https://img.shields.io/badge/Jakarta_EE-ED8B00?style=for-the-badge&logo=javaee&logoColor=white)](https://jakarta.ee/)
[![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-data-jpa)
[![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white)](https://spring.io/projects/spring-security)
[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white)](https://www.jetbrains.com/idea/)
[![Insomnia](https://img.shields.io/badge/Insomnia-5849BE?style=for-the-badge&logo=insomnia&logoColor=white)](https://insomnia.rest/)

</div>

## 🛠️ Technologies

- **Java**: Core programming language
- **Spring Boot 3**: Latest version of the application framework
- **Spring Security**: Authentication and authorization
- **Maven**: Dependency management and build automation
- **MySQL**: Database management system
- **Flyway**: Database migration tool
- **Swagger**: API documentation
- **Jakarta Validation**: Data validation
- **Spring Data JPA**: Database operations
- **IntelliJ IDEA**: Integrated development environment
- **Insomnia**: API testing and development tool

[Previous sections remain the same until Getting Started section]

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven
- MySQL Server
- IntelliJ IDEA (recommended) or your preferred IDE

### Database Setup

1. Create a MySQL database for the project
2. Create a `.env` file in the project root with the following variables:
```properties
DB_ADDRESS=localhost:3306
DB_NAME=your_database_name
DB_USER=your_username
DB_PASSWORD=your_password
JWT_SECRET=your_jwt_secret
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
git clone https://github.com/zlucasftw/medvoll-api.git
```

2. Navigate to project directory:
```bash
cd medvoll-api
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

