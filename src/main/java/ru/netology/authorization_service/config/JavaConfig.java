package ru.netology.authorization_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class JavaConfig {
    @Bean
    @Primary
    public String invalidCredentialMessage() {
        return new String("User name or password is empty");
    }

    @Bean
    public String unauthorizedUserMessage() {
        return new String("Unknown user ");
    }
}
