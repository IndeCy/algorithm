package List;


import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

    static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) {
        int i = 10;
        while(i>0){
            list.add(i);
        }
    }
}
