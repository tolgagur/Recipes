package task;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.*;


@RestController
public class Controller {
    Map<Integer, String> map = new ConcurrentHashMap<>();

    @GetMapping("/api/data/{id}")
    public Map<String, String> getData(@PathVariable int id) {
        return Map.of("data", map.get(id));
    }

    // add your code below this line

}
