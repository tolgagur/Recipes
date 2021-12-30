package task;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class Controller {

    private List<String> stringList = new ArrayList<>();

    @PostMapping("/users")
    public void addUser(@RequestParam String name){
        stringList.add(name);
    }
    @GetMapping("/users")
    public List<String> getUsers(){
        return stringList;
    }
}
