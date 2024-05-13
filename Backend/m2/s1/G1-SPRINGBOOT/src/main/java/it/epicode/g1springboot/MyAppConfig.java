package it.epicode.g1springboot;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyAppConfig {

    @Bean
    @Scope("singleton")

    public Counter getCounter() {
        var counter = new Counter();
        counter.setValue(10);
        return counter;
    }
}
