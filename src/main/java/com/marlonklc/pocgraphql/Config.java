package com.marlonklc.pocgraphql;

import graphql.scalars.ExtendedScalars;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.time.Clock;

@Configuration
public class Config {

    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }

    @Bean
    public RuntimeWiringConfigurer date() {
        return builder -> builder.scalar(ExtendedScalars.Date);
    }

    @Bean
    public RuntimeWiringConfigurer dateTime() {
        return builder -> builder.scalar(ExtendedScalars.DateTime);
    }
}
