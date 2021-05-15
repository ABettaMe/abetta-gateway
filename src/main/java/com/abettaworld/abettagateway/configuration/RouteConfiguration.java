package com.abettaworld.abettagateway.configuration;

import lombok.Getter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Map;

@Getter
@Configuration
public class RouteConfiguration {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder, UriConfiguration uriConfiguration) {

        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p
                        .path("/login/oauth2/code/google")
                        .uri("http://localhost:3000"))
//                .route(p -> p
//                        .path("/#")
//                        .uri("http://localhost:3000"))
//                .route(p -> p
//                        .path("/")
//                        .uri("http://localhost:3000"))
//                        .filters(f -> f.redirect(HttpStatus.PERMANENT_REDIRECT.toString(), "http://localhost:3000")))
                .route(p -> p
                        .path("/abetta-xp/**")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec.filters((exchange, chain) -> {
                            return exchange.getPrincipal()
                                    .map(principal -> {
                                        OAuth2User oauth2Principal =
                                                ((OAuth2AuthenticationToken) principal).getPrincipal();
                                        Map<String, Object> attributes = oauth2Principal.getAttributes();
                                        exchange.getRequest().mutate()
                                                .header("userId", (String) attributes.get(("sub")))
                                                .header("userEmail", (String) attributes.get("email"))
                                                .header("userFirstName", (String) attributes.get("given_name"))
                                                .header("userLastName", (String) attributes.get("family_name"))
                                                .header("userPictureUrl", (String) attributes.get("picture"))
                                                .build();
                                        exchange.getResponse().getHeaders().add("Access-Control-Allow-Origin", "http://localhost:3000");
                                        exchange.getResponse().getHeaders().add("Access-Control-Allow-Credentials", "true");
                                        return exchange;
                                    })
                                    .flatMap(chain::filter);
                        }))
                        .uri("forward:/test-controller"))
//                        .uri(uriConfiguration.getUrl()))
                .route(p -> p
                        .path("/something")
                        .filters(f -> f.addRequestHeader("Access-Control-Allow-Origin", "*"))
                        .uri("forward:/test-controller"))
                .build();
    }
}
