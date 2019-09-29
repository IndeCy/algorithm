package 测试private的边界;

public class Source {

    private Integer a;

    private String b;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public void fuseSource(Source target){
        System.out.println("target.a " + target.a);
        System.out.println("target get a " + target.getA());
        System.out.println("target.b " + target.b);
        System.out.println("target get b " + target.getB());

        System.out.println("source.a " + this.a);
        System.out.println("source get a " + this.getA());
        System.out.println("source.b " + this.b);
        System.out.println("source get b " + this.getB());
    }
}
