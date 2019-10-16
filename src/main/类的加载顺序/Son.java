package 类的加载顺序;

public class Son extends Father{

    public Son(){
        System.out.println("init son");
    }

    static int CONSTANT = 128;

    static void printTest(int a){
        System.out.println("son static method "+ a);
    }
}
