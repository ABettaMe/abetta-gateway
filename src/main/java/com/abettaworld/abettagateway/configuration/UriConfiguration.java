package com.abettaworld.abettagateway.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UriConfiguration {

    private final String experimentServiceUrl;

    public UriConfiguration(@Value("${com.abettaworld.services.experiment.url}") String experimentServiceUrl) {
        this.experimentServiceUrl = experimentServiceUrl;
    }

    public String getExperimentServiceUrl() {
        return this.experimentServiceUrl;
    }
}
