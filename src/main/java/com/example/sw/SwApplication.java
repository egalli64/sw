package com.example.sw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SwApplication {
    public static void main(String[] args) {
        SpringApplication.run(SwApplication.class, args);
    }

    @Bean
    protected CommandLineRunner beanCounter(ApplicationContext ctx) {
        return args -> System.out.println(ctx.getBeanDefinitionCount() + " beans available");
    }
}
