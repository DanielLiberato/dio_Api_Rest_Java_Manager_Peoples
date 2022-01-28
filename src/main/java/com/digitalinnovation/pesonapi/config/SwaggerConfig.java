package com.digitalinnovation.pesonapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springBlogPessoalOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Projeto api gerenciamento pessoas")
                        .description("Projeto Bootcamp Digital Innvation One")
                        .version("v0.0.1")
                        .license(new License()
                                .name("Digital innovation one ")
                                .url("https://web.dio.me"))
                        .contact(new Contact()
                                .name("Daniel Liberato da Silva")
                                .email("daniel.bacellar022@gmail.com")
                                .url("https://github.com/DanielLiberato")));
    }

    @Bean
    public OpenApiCustomiser customerGlobalResponseStatus() {
        return openApi -> {
            openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
                ApiResponses api = operation.getResponses();

                api.addApiResponse("200", createApiResponse("Sucesso !"));
                api.addApiResponse("201", createApiResponse("Criado!"));
                api.addApiResponse("400", createApiResponse("Erro na requisição!"));
                api.addApiResponse("401", createApiResponse("Não Autorizado!"));
                api.addApiResponse("500", createApiResponse("Servidor erro interno!"));
            }));
        };
    }

    private ApiResponse createApiResponse(String message) {
        return new ApiResponse().description(message);
    }
}