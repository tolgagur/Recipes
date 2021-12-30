import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

class ChooseCollection {
    public static void main(String[] args) throws Exception {
        Cat tiger = new Cat("Tiger", 3, "ginger");
        tiger.toString();

    }
}



@AllArgsConstructor
class Cat {
    String name;
    int age;
    String color;
}