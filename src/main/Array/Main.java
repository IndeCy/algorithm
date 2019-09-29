package main.Array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("a",new Long[]{1L,3L});

        Long[] b = (Long[]) map.get("a");
    }

    public List testMethod(List<List<String>> list, String str, int i, List result) {
        List<String> l = list.get(i);
        for (String string : l) {
            String str2 = str + string;
            if (i != list.size() - 1) {
                int j = i + 1;
                testMethod(list, str2, j, result);
            } else {
                result.add(str2);
            }
        }
        return result;
    }
}
