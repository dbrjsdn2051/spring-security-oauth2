package io.security.oauth2.springoauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ClientRegistrations;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

import java.util.List;

@Configuration
public class OAuth2ClientConfig {

    @Bean
    public ClientRegistrationRepository clientRegistration() {
        return new InMemoryClientRegistrationRepository(keycloakClientRegistration());
    }

    private ClientRegistration keycloakClientRegistration() {
        return ClientRegistrations.fromIssuerLocation("http://localhost:8080/realms/master")
                .clientId("oauth2-client-app")
                .clientSecret("j9grHkV7sKiXyr5zV5kksEkwFbGrpk5v")
                .redirectUri("http://localhost:8081/login/oauth2/code/keycloak") // 필수 아님
                .issuerUri("http://localhost:8080/realms/master")
                .build();
    }
}
