package com.moniguar.boot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Solución a prueba de bloques")
                        .version("1.0")
                        .description("Escribe un api que determine si la palabra dada se puede escribir con la colección de bloques dada")
                        .termsOfService("")
                        .license(new License().name("Tomcat web server").url("")));

    }

}
