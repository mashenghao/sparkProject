package chapter1

/**
 * hello的细节：
 *1. object表示一个伴生对象，简单理解为就是一个类的实例对象.
 *
 *2. AHello就是对象名字，他底层真正对应的类名是AHello$,
 * 对象实例是AHello$类型的一个静态对象MODULE$.
 *
 * 个人理解： AHello就是一个对象的名字，他的类型是AHello$类，这个对象名字
 * 指向的对象是AHello$的一个静态对象实例名字叫MODULE$.
 * 反编译查看：
 * import scala.Predef.;
 * public final class AHello$ //这个是AHello对象的类，
 * {
 * public static final  MODULE$;//静态变量MODULE$，是AHello$的静态变量，在类加载的时候，会被赋予值。
 * static
 * {
 * new ();
 * }
 * public void main(String[] args)
 * {
 *         Predef..MODULE$.println("hello world");
 * }
 * private AHello$() { MODULE$ = this; }
 * }
 *
 *
 * public final class AHello  //AHello是object实例，真实的逻辑是调用AHello$类静态变量MODEULE$的main方法。
 * {
 * public static void main(String[] paramArrayOfString)
 * {
 * AHello$.MODULE$.main(paramArrayOfString);
 * }
 * }
 *
 * 3. 分析scala运行的流程：
 *    a.一个object会生成两个class文件，一个是类型文件，一个是对象文件，类型文件是对象名$,所以当执行的时候，
 * 获取加载类，会首先加载AHello$. 加载时会执行static方法，对类进行初始化，因而MODULE$被赋予了值。
 * public static final  MODULE$;
 * static
 * *    {
 * *      new ();
 * *    }
 * private AHello$() { MODULE$ = this; }
 *  b.程序的入口是object的main方法，翻译成字节码则是，将对象Object也翻译成了一个类，实际执行的
 * 方法，则是调用AHello$.MODULE$静态对象的方法。
 * public final class AHello
 * {
 * public static void main(String[] paramArrayOfString)
 * {
 * AHello$.MODULE$.main(paramArrayOfString);
 * }
 * }
 *  c.MODULE$执行main方法。
 * public void main(String[] args)
 * {
 *     Predef..MODULE$.println("hello world");
 * }
 *
 *  总结： 貌似还不太懂，object的作用，感觉就是一个类，剔出来一个静态变量，
 *  吧这个静态变量给别人，让别人调用类的方法的作用。
 */
object AHello {
  def main(args: Array[String]): Unit = {
    println(method1(2))
    println("hello world")
  }

  /*
  public static int method1(int paramInt)
  {
    return AHello$.MODULE$.method1(paramInt);
  }

  在类中：AHello$

  public int method1(int i) {
    return i + 1;
  }

   */
  def method1(i: Int): Int = {
    i + 1
  }
}
