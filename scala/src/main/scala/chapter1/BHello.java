package chapter1;

/**
 * @author: mahao
 * @date: 2020/7/26
 * 使用java模拟scala的运行。
 * 模拟发现，我们知道object就是对scala做了一个包装。
 * 当看到object时，我们可以看到这个是class的一个静态实例，并且是单例的。
 *
 */
//模拟的是AHello$类
public class BHello {

    public static final BHello MODULE;

    static {
        MODULE = new BHello();
    }

    private BHello() {

    }

    //这里的main，才是真正的执行方法的地方。
    public void main(String[] args) {
        // Predef..MODULE$.println(BoxesRunTime.boxToInteger(method1(2)));
        // Predef..MODULE$.println("hello world");
    }

    //object中的方法，这里面的也必须有。
    public int method1(int i) {
        return i + 1;
    }
}

//模拟的是object的AHello对象
class BHelloObject {

    public static void main(String[] args) {
        BHello.MODULE.main(args); //调用类里面去执行。
    }

    //定义的方法，对应java就是静态方法去调用类里面的方法。方法名称和类里面的实际方法一样。
    public static int method1(int i) {
        return BHello.MODULE.method1(i);
    }
}