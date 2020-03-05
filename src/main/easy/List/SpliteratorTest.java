package easy.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorTest {

    static List<String> ls = new ArrayList<>(8);


    public static void main(String[] args) {
        ls.add("aa");
        ls.add("bb");
        ls.add("cc");
        ls.add("dd");
        ls.add("ee");
        ls.add("ff");
        Spliterator<String> spliterator = ls.stream().spliterator();
        spliterator.trySplit().trySplit().forEachRemaining(System.out::println);
        spliterator.trySplit().forEachRemaining(System.out::println);
//        spliterator.forEachRemaining(System.out::println);

    }
}
