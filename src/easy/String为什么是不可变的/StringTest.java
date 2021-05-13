package easy.String为什么是不可变的;

public class StringTest {

    public String str = "abc";

    public Integer i = 1;

    public void exchange(Integer j,String str,char[] chars){
        System.out.println(str);
        str = "bbb";
        System.out.println(str);
        chars[0] = 'g';
        System.out.println(j);
        j = 2;
        System.out.println(j);
    }

}
