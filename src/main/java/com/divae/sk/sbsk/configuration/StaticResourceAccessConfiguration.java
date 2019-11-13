package com.divae.sk.sbsk.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class StaticResourceAccessConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/files/**")
                .addResourceLocations("file:src/main/resources/static/"); // file: = relativer pfad, funktioniert
//                .addResourceLocations("file:///C:/Users/stefan.kufer/IdeaProjects/sbsk/src/main/resources/static/"); // file:/// = absoluter pfad, funktioniert
    }
}
