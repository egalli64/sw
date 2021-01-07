package sbr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }

    @Bean
    public CommandLineRunner beanCounter(ApplicationContext ctx) {
        return args -> {
            int count = ctx.getBeanDefinitionCount();
            System.out.println(String.format("You have access to %d Spring Beans", count));
        };
    }
}
