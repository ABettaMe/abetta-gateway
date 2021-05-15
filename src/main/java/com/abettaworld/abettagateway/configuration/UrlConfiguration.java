package com.abettaworld.abettagateway.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "com.abettame.urls")
public class UrlConfiguration {

    private String experimentServiceUrl;

    private String clientPortalUrl;
}
