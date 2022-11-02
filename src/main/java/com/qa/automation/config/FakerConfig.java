package com.qa.automation.config;

import com.github.javafaker.Faker;
import com.qa.automation.annotation.LazyConfiguration;

import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker getFaker(){
        return new Faker();
    }

}
