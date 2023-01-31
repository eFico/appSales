package org.alfa.pharmax.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedMethods("*")
        //.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
        .allowedOrigins("*").maxAge(3600);
    }

}
