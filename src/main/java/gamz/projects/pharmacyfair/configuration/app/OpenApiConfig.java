package gamz.projects.pharmacyfair.configuration.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "API для цифрового сопровождения конкурса разработок в сфере медицины",
        version = "v1",
        description = "API для цифрового сопровождения конкурса разработок. Реализует регистрацию участников, " +
                "прием и обработку поданных проектов/заявок индустриальных партнеров, и многостороннее " +
                "взаимодействие участников мероприятия друг с другом и с организаторами."))
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer")
public class OpenApiConfig {
}
