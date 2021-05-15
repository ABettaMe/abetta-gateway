package com.abettaworld.abettagateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity) {
        serverHttpSecurity
//                .cors()
//                .and()
                .authorizeExchange()
                .pathMatchers("/get", "/something").permitAll()
                .pathMatchers("/login", "/abetta-xp/**").authenticated()
                .and()
                .oauth2Login();
        return serverHttpSecurity.build();
    }

//    @Bean
//    CorsWebFilter corsWebFilter(UriConfiguration uriConfiguration) {
//        CorsConfiguration corsConfig = new CorsConfiguration();
//        corsConfig.setAllowedOrigins(Collections.singletonList(uriConfiguration.getAllowedOrigin()));
//        corsConfig.addAllowedMethod("PUT");
//        corsConfig.addAllowedMethod("GET");
//        corsConfig.addAllowedMethod("POST");
//        corsConfig.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfig);
//
//        return new CorsWebFilter(source);
//    }
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowCredentials(true);
//        configuration.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
//        configuration.setAllowedMethods(Collections.singletonList("*"));
//        configuration.setAllowedHeaders(Collections.singletonList("*"));
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }

//    @Bean
//    public CorsFilter corsFilter() {
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        final CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.setAllowedOrigins(List.of("https://example.com"));
//        config.setAllowedHeaders(List.of("Origin", "Content-Type", "Accept"));
//        config.setAllowedMethods(List.of("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }
//
//    @Bean
//    CorsWebFilter corsWebFilter() {
//        CorsConfiguration corsConfig = new CorsConfiguration();
//        corsConfig.setAllowCredentials(true);
//        corsConfig.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
//        corsConfig.setMaxAge(3600L);
//        corsConfig.addAllowedMethod("*");
//        corsConfig.addAllowedHeader("*");
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfig);
//
//        return new CorsWebFilter(source);
//    }
//
//    @Bean
//    public CorsFilter corsFilter() {
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        final CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        // Don't do this in production, use a proper list  of allowed origins
//        config.setAllowedOrigins(Collections.singletonList("*"));
//        config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept"));
//        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }

//    @Bean
//    CorsWebFilter corsWebFilter() {
//        CorsConfiguration corsConfig = new CorsConfiguration();
//        corsConfig.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
//        corsConfig.setMaxAge(8000L);
//        corsConfig.addAllowedMethod("*");
//        corsConfig.addAllowedHeader("*");
//
//        UrlBasedCorsConfigurationSource source =
//                new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfig);
//
//        return new CorsWebFilter(source);
//    }
}
