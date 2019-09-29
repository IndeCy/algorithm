import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    public static final String REGEX_URL = "^(http(s){0,1}:\\/\\/.+?)(\\/|\\?|$)";




    public static void main(String[] args) {

       /* TestBoolean a = new TestBoolean();
        System.out.println(a.isA());
        System.out.println(a.getB());*//*
        String url = "https://s-test.shoubaodao.com/a1/recommend?SESSIONID=fasdfsdfsdf";
        System.out.printf(replaceUrl(url));*/
      /*  System.out.println(null+"");
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("autoFlag","0");
        System.out.println(stringObjectHashMap.get("autoFlag"));
        System.out.println((int)stringObjectHashMap.getOrDefault("autoFlag",1));*/
//        Integer a = 1;
//
//        String s = "a";
//
//        System.out.println(a+s);
//        System.out.println(s+a);
//        Arrays.stream(testArr()).forEach(System.out::println);
//
//        String aaa = "a,b,b,b";
//        String bbb = "c,c,b";
//        int ccc = Integer.MAX_VALUE;
//        System.out.println(ccc);
        Integer a = new Integer(500000);
        Integer b = new Integer(500000);
        System.out.println(a==500000);

    }

    public static String replaceUrl(String url) {
        Pattern p = Pattern.compile(REGEX_URL,Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(url);
        matcher.find();
        return  matcher.group(1);
    }

    public static String[] testArr(){
        ArrayList<String> objects = new ArrayList<>();
        objects.add("aaa");
        objects.add("aaa");
        objects.add("ccc");
        objects.add("bbb");

        String[] ss = new String[objects.size()];
        objects.toArray(ss);
        return ss;
    }


}
