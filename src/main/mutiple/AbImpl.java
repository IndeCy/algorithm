package mutiple;

public class AbImpl extends C implements Ab,A,B{

    @Override
    public void method() {
        System.out.println("abIm");
    }

    public static void main(String[] args) {

        new AbImpl().method();
    }

}
