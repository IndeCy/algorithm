package 验证private的用法;

public class Father {

    final private String a = "abc";

    final void print(String a){
        System.out.println(a);
        System.out.println(this.a);
    }
}
