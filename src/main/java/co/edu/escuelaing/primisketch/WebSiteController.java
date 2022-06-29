package co.edu.escuelaing.primisketch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WebSiteController {

    public static void main(String[] args) {
        SpringApplication.run(WebSiteController.class, args);
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET, produces = "application/json")
    public String status() {
        return "{\"status\":\"Greetings from Spring Boot. "
                + java.time.LocalDate.now() + ", "
                + java.time.LocalTime.now()
                + ". " + "The server is Runnig!\"}";
    }

}
