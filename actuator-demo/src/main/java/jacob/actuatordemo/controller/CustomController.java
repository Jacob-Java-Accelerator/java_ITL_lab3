package jacob.actuatordemo.controller;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "my-custom-check")
public class CustomController {

    @ReadOperation
    public String hello() {
        return "The Application is fine";
    }
}
