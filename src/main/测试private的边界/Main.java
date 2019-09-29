package 测试private的边界;

public class Main {
    public static void main(String[] args) {

        Source source = new Source();
        source.setA(1);
        source.setB("source");

        Source target = new Source();
        target.setA(2);
        target.setB("target");

        source.fuseSource(target);
    }
}
