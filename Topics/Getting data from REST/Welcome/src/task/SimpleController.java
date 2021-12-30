package task;

import org.springframework.web.bind.annotation.*;

@RestController
public class SimpleController {

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome!";
    }
}
