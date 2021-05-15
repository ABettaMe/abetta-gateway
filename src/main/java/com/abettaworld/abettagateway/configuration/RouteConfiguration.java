package com.abettaworld.abettagateway.configuration;

import lombok.Getter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class RouteConfiguration {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder, UrlConfiguration urlConfiguration) {

        return builder.routes()
                .route(p -> p
                        .path("/*")
                        .uri(urlConfiguration.getClientPortalUrl()))
                .route(p -> p
                        .path("/static/**")
                        .uri(urlConfiguration.getClientPortalUrl()))
                .route(p -> p
                        .path("/abetta-xp/**")
                        .uri(urlConfiguration.getExperimentServiceUrl())
                ).build();
    }
}
