package easy.集合交并集测试;

import java.util.HashSet;
import java.util.Set;

public class RetainTest {

    public static void main(String[] args) {

        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        for (int i = 0; i < 15; i++) {
            a.add(i);
        }
        for (int i = 0; i < 10; i++) {
            b.add(i);
        }
        a.retainAll(b);
        System.out.println(a);
    }
}
