package com.abettaworld.abettagateway.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class UriConfiguration {

    private final String experimentServiceUrl;

    private final String allowedOrigin;

    public UriConfiguration(@Value("${com.abettaworld.services.experiment.url}") String experimentServiceUrl,
                            @Value("${com.abettaworld.allowed.origin}") String allowedOrigin) {
        this.experimentServiceUrl = experimentServiceUrl;
        this.allowedOrigin = allowedOrigin;
    }
}
