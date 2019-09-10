package DateStructorTest;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MyHashMap extends HashMap {
    public static void main(String[] args) {
        LinkedHashMap lmap = new LinkedHashMap();

        lmap.put("a","");

        int a= 1;
        int b = 2;

        int c = 3;
        a=b=c;

        System.out.println(a+b+""+c);
    }

}
