package system787.wowtool.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("system787.wowtool")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext
                = SpringApplication.run(Application.class, args);
    }

}
