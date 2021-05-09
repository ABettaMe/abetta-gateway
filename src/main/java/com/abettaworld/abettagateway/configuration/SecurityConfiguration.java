package com.abettaworld.abettagateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity) {
        serverHttpSecurity.authorizeExchange()
                .pathMatchers("/get", "/something").permitAll()
                .pathMatchers("/login", "/abetta-xp/**").authenticated()
                .and()
                .oauth2Login();
        return serverHttpSecurity.build();
    }
}
