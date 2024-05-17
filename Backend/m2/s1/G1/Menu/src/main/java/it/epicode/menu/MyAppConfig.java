package it.epicode.menu;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {

    @Bean(name = "pizza")
    Counter getCounter() {
        System.out.println("Sto eseguendo getCounter()");
        return new Counter();
    }


}
