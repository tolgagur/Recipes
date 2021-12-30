import java.util.*;
import java.util.stream.Collectors;

class CollectionUtils {

    public static Collection<Integer> pow2(Collection<Integer> numbers) {
        Collection<Integer> num = new ArrayList<>();

        int x;
        for (Integer integer : numbers){
            x = integer*integer;
            num.add(x);

        }
        return num;
    }
}

/* Please, do not modify this I/O code */
public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new LinkedList<>();
        list2.add(3);
        list2.add(2);
        list2.add(1);

        List<Integer> list3 = List.of(1, 2, 3);

        List<Integer> list4 = List.of(1, 1, 2, 2, 3, 3);
        System.out.println(list1.equals(list1));

        System.out.println(list1.equals(list2));

        System.out.println(list1.equals(list3));

        System.out.println(list2.equals(list3));

        System.out.println(list3.equals(list4));
    }
}