package main.lambda赋值;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Package: main.lambda赋值
 * @Author: chenyang
 * @Date: 2021/2/5
 * @Version: 1.0
 */
public class LambdaT {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("a","a");
        map.put("a2","a");
        map.put("a1","a");
        map.put("a3","a");

        System.out.println("before:" + map);

        try {

            map = Stream.of("b", "b1", "b2",null).collect(Collectors.toMap(x -> x.hashCode() + "_" + x, Function.identity()));
        }catch (Exception e){
            System.out.println("err");
        }

        System.out.println("after:" + map);

    }



}
