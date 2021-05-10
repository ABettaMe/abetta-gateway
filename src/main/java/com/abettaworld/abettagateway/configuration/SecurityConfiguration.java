package com.abettaworld.abettagateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Collections;

@EnableWebFluxSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity) {
        serverHttpSecurity.authorizeExchange()
                .pathMatchers("/get").permitAll()
                .pathMatchers("/login", "/abetta-xp/**", "/something").authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();
//                .jwkSetUri("https://accounts.google.com/.well-known/openid-configuration");
        return serverHttpSecurity.build();
    }

    @Bean
    CorsWebFilter corsWebFilter(UriConfiguration uriConfiguration) {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Collections.singletonList(uriConfiguration.getAllowedOrigin()));
        corsConfig.addAllowedMethod("PUT");
        corsConfig.addAllowedMethod("GET");
        corsConfig.addAllowedMethod("POST");
        corsConfig.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }
}
