package umc.spring.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(

    info = @Info(title = "UMC Server WorkBook API", description = "UMC Server WorkBook API 명세서", version = "v1.0.0"),
    servers = {
        @Server(url = "http://localhost:8080", description = "로컬 URL")
    }
)
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI umcStudyAPI() {

    String jwtSchemeName = "JWT TOKEN";
    SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwtSchemeName);
    Components components = new Components()
        .addSecuritySchemes(jwtSchemeName, new SecurityScheme()
            .name(jwtSchemeName)
            .type(SecurityScheme.Type.HTTP)
            .scheme("bearer")
            .bearerFormat("JWT"));

    return new OpenAPI()
        .addSecurityItem(securityRequirement)
        .components(components);
  }
}