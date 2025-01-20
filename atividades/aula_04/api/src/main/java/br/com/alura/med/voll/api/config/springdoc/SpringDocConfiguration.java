package br.com.alura.med.voll.api.config.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("Voll.med API")
                        .description("REST API for the Voll.med application, including CRUD operations " +
                                "for doctors and patients, as well as booking and cancellation of appointments.")
                        .contact(new Contact()
                                .name("Backend Team")
                                .email("backend@voll.med"))
                        .license(new License()
                                .name("AGPL V3")
                                .url("http://voll.med/api/license")));
    }

}
