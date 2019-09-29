package 验证private的用法;


/**
 * 结论 private修饰的属性子类无法调用到也无法继承（private隐式声明了final）
 * public 或者 default修饰的final属性子类无法重写但是可以重载
 */
public class Son extends Father{

    public void print(){
        super.print("a");
    }
}
