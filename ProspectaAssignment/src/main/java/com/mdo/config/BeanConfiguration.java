package com.mdo.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {

    @Bean
    RestTemplate resttemplate(RestTemplateBuilder restbuilder) {
        RestTemplate restTemplate = restbuilder.build();
        return restTemplate;
    }

}
