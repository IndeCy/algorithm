package easy.测试常规ArrayList的toArray返回值;

import java.util.*;

public class Main {


    static List<String> normal = new ArrayList<>();
    static List<String> myList = new MyList();
    static Set<String> set = new HashSet<>();

    static class MyList extends ArrayList<String> {

        public String[] toArray(){
            return new String[]{"1","2","3"};
        }
    }


    public static void main(String[] args) {
        System.out.println(normal.toArray().getClass());
        System.out.println(myList.toArray().getClass());
    }
}
