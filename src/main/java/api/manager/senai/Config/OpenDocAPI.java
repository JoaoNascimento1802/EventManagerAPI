package api.manager.senai.Config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenDocAPI {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Gerenciador de Eventos")
                        .description("Documentação da API para gerenciamento de eventos")
                        .version("1.0.0"));
    }
}
