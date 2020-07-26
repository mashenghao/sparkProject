package cn.mh.p1

/**
 * 创建一个对象Object，和类不一样。
 * 1.Scala object相当于java中的单例，object定义的全是静态的。
 * 2.scala中定义变量使用var，常量是用val，类型不用指定，可以自己推动。val易于回收。
 * 9.在使用class的时候，如果没有显示赋值，可以去看类中是否用代码块赋值了。
 */
object HelloWorld {

  //11.object不支持传入参数，当使用object传入参数的时候，是因为支持默认的
  def apply(arg: String): Unit = {
    println(s"调用object默认的对象的apply方法，数值是： ${arg}")
  }

  //7.验证object中定义的方法和实例都是静态的，在这里面定义
  //定义方法和变量，在Person类中，可以直接类名.方法调用。
  //去7.1可以看到直接调用成功了。
  var staticVar = "我是静态变量"

  def staticMethod(): String = {
    "我是静态方法的返回值"
  }


  def main(args: Array[String]): Unit = {

    //1、scala打印语句
    println("hello word")

    //2.scala中的变量和常量定义
    val a: Int = 200 //常量，定义后不允许在赋值
    var b = 100 //变量，支持在赋值操作，但不利于对象回收。
    println(a)
    println(b)

    // a=10   不支持，会报错
    b = 10
    println(b)

    //4.创建对象，通过new
    val p = new Person("zs", 18, "男")
    println("打印对象的值： " + p)

    //5.获取类对象的值，通过 .,可以获取类的属性值，也可以获取参数的值，但是
    //要被修饰的参数才可以。
    println("获取类属性的值：" + p.name)
    println("获取构造参数的值：" + p.iname)

    //6.方法的调用与定义,无法使用Person调用方法，必须用实例对象
    p.method1("zhangsan");


    //9.验证代码块的执行顺序，顺序是，按照出现的顺序依次执行的。
    var p2 = new Person("zs", 18, "男")
    println(s"打印p2的值是多少，默认是0，代码块赋值12，构造方法赋值18 最终为： ${p2.age}")


    //10.访问私有变量
    // p2.myVar //只有在半生累的时候才行。


    //调用apply方法
    HelloWorld("我传入参数，要调用object的apply方法。")
  }
}

//3. 创建类，类可以带括号和参数，参数指定类型。
//构造参数不用val或者var修饰，表示变量是私有的，修饰了，参数是可以被外界访问到的。
class Person(val iname: String, var iage: Int, sex: String) {


  val name = iname

  var age = 10
  age = iage

  //这里是使用代码块赋值，去看9。每次new对象，都会被调用。感觉就是代码块。
  {
    age = 12
  }


  //8.构造函数的重载
  def this() {
    this("zs", 18, "男") //必须显示的调用默认的构造方法。
    //第一行默认的构造行数
  }

  def this(name: String) {
    this(name, 19, "nane") //必须调用默认的构造。
  }

  /**
   * 6、方法的定义;
   * def 方法名（参数名：参数类型）：返回值= {
   *
   * }
   */
  def method1(name: String): Unit = {
    println(s"定义的方法的返会值：  = ${name}")
  }

  //7.1 验证静态方法的调用。
  val aa = HelloWorld.staticVar;
  println(s"aa的值是${aa}")
  val bb = HelloWorld.staticMethod()
  println(s"bb的值是${bb}")


  //10,private私有变量，不允许外界访问，但是，当类名和对象名一样时，就是
  //伴生类和伴生对象。
  private var myVar = 10;
}