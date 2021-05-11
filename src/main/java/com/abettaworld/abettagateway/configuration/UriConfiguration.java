package com.abettaworld.abettagateway.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "com.abettaworld.services.experiment")
public class UriConfiguration {

    private String url;
}
