import java.util.*;

class MapUtils {
    public static Map<Integer, String> getSubMap(TreeMap<Integer, String> map) {
        TreeMap<Integer, String> map1 = new TreeMap<>();
        if (map.firstKey()%2 != 0){
            for (int i=map.firstKey()+4;i>0;i--){
                    map1.put(i,map.get(i));
            }
        }else {

            for (int i=map.lastKey();i>=(map.lastKey()-4);i--){
                if (map.containsKey(i)!=false)
                    map1.put(i,map.get(i));
            }
        }
        return map1.descendingMap();
    }
}
/* Do not modify code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Integer, String> map = new TreeMap<>();
        Arrays.stream(scanner.nextLine().split("\\s")).forEach(s -> {
            String[] pair = s.split(":");
            map.put(Integer.parseInt(pair[0]), pair[1]);
        });
        Map<Integer, String> res = MapUtils.getSubMap(map);
        res.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}