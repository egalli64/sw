package com.example.sw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SwApplication {
    private static Logger log = LoggerFactory.getLogger(SwApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SwApplication.class, args);
    }

    @Bean
    /**
     * A Bean factory
     * <p>
     * CommandLineRunner and ApplicationRunner beans are automatically executed when
     * the context is ready.
     * 
     * @param ctx the context in which the bean is going to be registered
     * @return the generated bean
     */
    protected CommandLineRunner beanCounter(ApplicationContext ctx) {
        log.trace("Generating a simple bean");
        CommandLineRunner bean = args -> System.out
                .println("The bean counter sees " + ctx.getBeanDefinitionCount() + " beans available");
        return bean;
    }
}
