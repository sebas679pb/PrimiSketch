package co.edu.escuelaing.primisketch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "co.edu.escuelaing.primisketch" })
@SpringBootApplication
public class WebSiteController {

    public static void main(String[] args) {
        SpringApplication.run(WebSiteController.class, args);
    }

}
