import java.util.*;


class MapFunctions {

    public static void calcTheSamePairs(Map<String, String> map1, Map<String, String> map2) {
        int value = map2.size();
        map1.forEach((k,v)-> map2.remove(k,v));
        System.out.println(value-map2.size());

    }
}
