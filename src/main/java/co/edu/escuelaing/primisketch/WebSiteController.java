package co.edu.escuelaing.primisketch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Controlador de sitio web
 */
@ComponentScan(basePackages = { "co.edu.escuelaing.primisketch" })
@SpringBootApplication
public class WebSiteController {

    /**
     * Inicia el controlador de sitio web
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(WebSiteController.class, args);
    }

}
