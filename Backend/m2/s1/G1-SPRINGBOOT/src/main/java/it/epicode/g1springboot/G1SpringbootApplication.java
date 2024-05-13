package it.epicode.g1springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class G1SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(G1SpringbootApplication.class, args);
var myCounter = new Counter();
myCounter.increment();

var myCounter2 = new Counter();
myCounter2.increment();

//System.out.println(myCounter);
//System.out.println(myCounter2);


var ctx = new AnnotationConfigApplicationContext(MyAppConfig.class);
var c1 = ((Counter)ctx.getBean(Counter.class));
var c2 = ((Counter)ctx.getBean(Counter.class));
System.out.println(c1);
System.out.println(c2);

    }

}
