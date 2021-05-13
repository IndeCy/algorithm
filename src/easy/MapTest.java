package easy;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("pro","12345");
//        map.put("pro2",null);

        map.putIfAbsent("pro","333");
        map.putIfAbsent("pro2","4444");

        System.out.println(map.get("pro").toString());
        System.out.printf(map.get("pro2").toString());

        "".toString();
    }

}
