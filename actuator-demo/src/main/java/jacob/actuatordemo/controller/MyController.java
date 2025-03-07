package jacob.actuatordemo.controller;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot Actuator!";
    }

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint!";
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return "This is an admin endpoint!";
    }

    @GetMapping("/user")
    public String userEndpoint() {
        return "This is a user endpoint!";
    }
}
