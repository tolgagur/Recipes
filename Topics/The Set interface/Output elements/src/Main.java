import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<String> nameSet = new TreeSet<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));
        // write your code here
        Iterator i = nameSet.iterator();
        while(i.hasNext()){
            System.out.println(i.next()); 
            
        }
    }
}
