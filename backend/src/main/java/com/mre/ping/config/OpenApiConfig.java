package com.mre.ping.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class OpenApiConfig {

    @Bean
    @Profile("!prod")
    public GroupedOpenApi actuatorApi() {
        return GroupedOpenApi.builder().group("Actuator")
                .pathsToMatch("/actuator/**")
                .pathsToExclude("/actuator/health/*")
                .build();
    }
}

