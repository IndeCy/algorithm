package easy.collections空集合测试;

import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List a = Collections.emptyList();
        List<Object> b = Collections.emptyList();
        List c = Collections.emptyList();
        System.out.println((c == a));
    }
}
