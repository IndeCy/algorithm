package 多线程.交替打印foobar1115;

class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    private volatile boolean fooRun = true;
    private final Object obj = new Object();


    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            synchronized (obj) {
                if (!fooRun) {
                    obj.wait();
                }
                printFoo.run();
                fooRun = false;
                obj.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized (obj) {
                if (fooRun) {
                    obj.wait();
                }
                printBar.run();
                fooRun = true;
                obj.notifyAll();
            }
        }
    }
}