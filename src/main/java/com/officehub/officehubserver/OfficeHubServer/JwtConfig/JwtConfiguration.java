package com.officehub.officehubserver.OfficeHubServer.JwtConfig;


import com.officehub.officehubserver.Authentication.JwtAuthTokenProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfiguration {

    @Value("${jwt.base64-secret}")
    private String base64Secret;

    @Bean
    public JwtAuthTokenProvider jwtProvider() {
        return new JwtAuthTokenProvider(base64Secret);
    }
}
