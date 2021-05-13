package easy.Lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println(new Lambda().checkPwd("true",s -> s.equals("true")));

    }
}
