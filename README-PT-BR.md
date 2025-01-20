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

## 📋 Descrição

Med Voll API é um sistema robusto de gerenciamento de saúde construído com Java e Spring Boot 3. Este projeto foi desenvolvido como parte do curso "Spring Boot 3: documente, teste e prepare uma API para o deploy". Ele fornece funcionalidades abrangentes para gerenciar pacientes, médicos e consultas médicas, oferecendo operações contínuas para registro, listagem, atualização e exclusão de registros.

## 🛠️ Tecnologias

- **Java**: Linguagem de programação principal
- **Jakarta Validation**: Validação de dados
- **Spring Boot 3**: Versão mais recente do framework
- **Spring Data JPA**: Operações de banco de dados
- **Spring Security**: Autenticação e autorização
- **Flyway**: Ferramenta de migração de banco de dados
- **Maven**: Gerenciamento de dependências e automação de build
- **MySQL**: Sistema de gerenciamento de banco de dados
- **Swagger**: Documentação da API
- **IntelliJ IDEA**: Ambiente de desenvolvimento integrado
- **Insomnia**: Ferramenta de teste e desenvolvimento de API

## 📁 Estrutura do Projeto

```
src/main/java/med/voll/api/
├── controller/     # Endpoints da API
├── domain/        # Lógica de negócios e repositórios
└── infra/         # Configurações e infraestrutura
```

## 🔄 Endpoints da API

### 👤 Pacientes

| Método | Endpoint | Descrição |
|:------:|----------|-------------|
| ![POST](https://img.shields.io/badge/-POST-4CAF50?style=for-the-badge&logo=post&logoColor=white&labelColor=4CAF50&logoWidth=0) | `/pacientes` | Registrar novo paciente |
| ![GET](https://img.shields.io/badge/-GET-2196F3?style=for-the-badge&logo=get&logoColor=white&labelColor=2196F3&logoWidth=0) | `/pacientes` | Listar pacientes ativos |
| ![GET](https://img.shields.io/badge/-GET-2196F3?style=for-the-badge&logo=get&logoColor=white&labelColor=2196F3&logoWidth=0) | `/pacientes/{id}` | Obter detalhes do paciente |
| ![PUT](https://img.shields.io/badge/-PUT-FFA000?style=for-the-badge&logo=put&logoColor=white&labelColor=FFA000&logoWidth=0) | `/pacientes` | Atualizar informações do paciente |
| ![DELETE](https://img.shields.io/badge/-DELETE-F44336?style=for-the-badge&logo=delete&logoColor=white&labelColor=F44336&logoWidth=0) | `/pacientes/{id}` | Desativar paciente |

### 👨‍⚕️ Médicos

| Método | Endpoint | Descrição |
|:------:|----------|-------------|
| ![POST](https://img.shields.io/badge/-POST-4CAF50?style=for-the-badge&logo=post&logoColor=white&labelColor=4CAF50&logoWidth=0) | `/medicos` | Registrar novo médico |
| ![GET](https://img.shields.io/badge/-GET-2196F3?style=for-the-badge&logo=get&logoColor=white&labelColor=2196F3&logoWidth=0) | `/medicos` | Listar médicos ativos |
| ![GET](https://img.shields.io/badge/-GET-2196F3?style=for-the-badge&logo=get&logoColor=white&labelColor=2196F3&logoWidth=0) | `/medicos/{id}` | Obter detalhes do médico |
| ![PUT](https://img.shields.io/badge/-PUT-FFA000?style=for-the-badge&logo=put&logoColor=white&labelColor=FFA000&logoWidth=0) | `/medicos` | Atualizar informações do médico |
| ![DELETE](https://img.shields.io/badge/-DELETE-F44336?style=for-the-badge&logo=delete&logoColor=white&labelColor=F44336&logoWidth=0) | `/medicos/{id}` | Remover médico |

### 📅 Consultas

| Método | Endpoint | Descrição |
|:------:|----------|-------------|
| ![POST](https://img.shields.io/badge/-POST-4CAF50?style=for-the-badge&logo=post&logoColor=white&labelColor=4CAF50&logoWidth=0) | `/consultas` | Agendar consulta |
| ![DELETE](https://img.shields.io/badge/-DELETE-F44336?style=for-the-badge&logo=delete&logoColor=white&labelColor=F44336&logoWidth=0) | `/consultas` | Cancelar consulta |

## 📚 Documentação da API

Acesse a documentação da API através do Swagger. Exemplo de configuração:

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

## 🚀 Começando

### Pré-requisitos

- Java 17+
- Maven
- Servidor MySQL
- IntelliJ IDEA (recomendado) ou sua IDE de preferência

### Configuração do Banco de Dados

1. Crie uma base de dados no MySQL para o projeto
2. Crie um arquivo `.env` na raiz do projeto com as seguintes variáveis:
```properties
DB_ADDRESS=YOUR_DATABASE_ADDRESS
DB_NAME=YOUR_DATABASE_NAME
DB_USER=YOUR_DATABASE_USER
DB_PASSWORD=YOUR_DATABASE_PASSWORD
JWT_SECRET=YOUR_JWT_SECRET
```

### Propriedades da Aplicação

O projeto usa a seguinte configuração no `application.properties`:
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

### Passos de Instalação

1. Clone o repositório:
```bash
git clone https://github.com/zlucasftw/medvoll-api.git
```

2. Navegue até o diretório do projeto:
```bash
cd medvoll-api
```

3. Crie e configure o arquivo `.env` conforme descrito acima e ajuste o projeto para seu ambiente.

4. Execute a aplicação:
```bash
mvn spring-boot:run
```

A aplicação será iniciada e o Flyway executará automaticamente as migrações do banco de dados.

### Verificando a Instalação

1. A aplicação estará disponível em `http://localhost:8080`
2. Acesse a documentação do Swagger em `http://localhost:8080/swagger-ui.html`
3. Teste os endpoints usando o Insomnia com sua ferramenta de teste de API preferida

## 🤝 Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para:
- Abrir issues
- Enviar pull requests
- Sugerir melhorias

## 📄 Licença

Este projeto está licenciado sob a Licença AGPL V3 - veja [LICENSE](LICENSE) para mais detalhes.

---
<div align="center">
Parte do curso "Spring Boot 3: documente, teste e prepare uma API para o deploy"
</div>
