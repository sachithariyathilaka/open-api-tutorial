package io.github.sachithariyathilaka.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Configuration bean class for open api configurations.
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/03/24
 */
@Configuration
public class OpenAPIConfig {

    @Value("${swagger-server-description}")
    private String swaggerServerDescription;

    @Value("${swagger-server-url}")
    private String swaggerServerUrl;

    @Value("${swagger-contact-email}")
    private String swaggerContactEmail;

    @Value("${swagger-contact-name}")
    private String swaggerContactName;

    @Value("${swagger-contact-url}")
    private String swaggerContactUrl;

    @Value("${swagger-licence-name}")
    private String swaggerLicenceName;

    @Value("${swagger-licence-url}")
    private String swaggerLicenceUrl;

    @Value("${swagger-info-title}")
    private String swaggerInfoTitle;

    @Value("${swagger-info-version}")
    private String swaggerInfoVersion;

    @Value("${swagger-info-description}")
    private String swaggerInfoDescription;

    @Value("${swagger-info-terms}")
    private String swaggerInfoTerms;

    /**
     * Initiate the open api bean.
     *
     * @return the open api
     */
    @Bean
    public OpenAPI openAPI() {

        Server server = new Server();
        server.setUrl(swaggerServerUrl);
        server.setDescription(swaggerServerDescription);

        Contact contact = new Contact();
        contact.setEmail(swaggerContactEmail);
        contact.setName(swaggerContactName);
        contact.setUrl(swaggerContactUrl);

        License mitLicense = new License().name(swaggerLicenceName).url(swaggerLicenceUrl);

        Info info = new Info()
                .title(swaggerInfoTitle)
                .version(swaggerInfoVersion)
                .contact(contact)
                .description(swaggerInfoDescription)
                .termsOfService(swaggerInfoTerms)
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(server));
    }
}
