package cn.mh.p1

import java.util.Date

import javax.xml.crypto.Data

/**
 * @program: sparkProject
 * @Date: 2020/7/23 8:29
 * @Author: mahao
 * @Description: scala方法与函数
 */
object CFunction {

  def main(args: Array[String]): Unit = {
    /**
     * 1.方法定义.
     *1.方法返回值可以不写，会自动按照最后一行进行推断，但是如果返回添加了return，则必须到
     * 方法的返回值。
     * 2.方法与方法体之间的=，如果不加，则返回值是unit。
     *
     * 方法返回值有时候不能省略，必须写，比如在递归方法中或者方法的返回值是函数类型的时候
     *
     */
    def max(a: Int, b: Int): Int = {
      if (a > b) return a
      else b
    }

    def max2(a: Int, b: Int) {
      if (a > b) a
      else b
    }

    val m1 = max(1, 2)
    val m2 = max2(1, 2)
    println(m1)
    println(m2) //返回值为空

    val i = recursion(100)
    println(s"递归100值是： ${i}")

    val i1 = Default_parameters()
    val i2 = Default_parameters(b = 18) //单独赋值。
    println("参数有默认值的方法： " + i1)
    println("参数有默认值的方法2： " + i2)

    //可变参数
    var_para("11", "22", "33")

    printLine("匿名函数")
    //5.匿名函数
    /**
     * 匿名函数可以将返回值定义给一个变量。
     */
    //有参匿名函数,可以将匿名函数返回给定义的一个变量。
    val value1 = (a: Int) => {
      println(a)
    }
    value1(1)
    //无参匿名函数
    val value2 = () => {
      println("aaaa")
    }
    value2()
    //有返回值的匿名函数,不能带return
    val value3 = (a: String, b: String) => {
      a + b
    }
    println(value3("aa", "bb"))


    printLine("6.嵌套方法")

    /*
     * 在方法里面嵌套方法使用
     */
    def outMethod(a: Int): Unit = {

      def inMethod(i: Int): Int = {
        println(a) //内部方法可以使用外部方法。
        if (i > 1) inMethod(i - 1) + i
        else 1
      }

      var result = inMethod(a)
      println("结果是：  " + result)
    }

    outMethod(5)


    printLine("7.偏应用函数")

    def log(date: Date, s: String) = {
      println(date + "    " + s)
    }

    //批量调用
    val date = new Date()
    log(date, "aa")
    log(date, "bb")
    log(date, "cc")

    //想要调用log，以上变化的是第二个参数，可以用偏应用函数处理
    val logWithData = log(date, _: String)
    logWithData("aa")
    logWithData("bb")
    logWithData("cc")


    printLine("8.高阶函数")

    /*
    高阶函数定义：
    参数/返回值/两者都是函数
     */
    //1.参数是函数
    //先定一个函数
    def f1(a: Int, b: Int): Int = (a + b)

    //函数f和参数a作为参数
    def hightFun(f: (Int, Int) => Int, a: Int): Int = {
      f(a, 100)
    }

    println("函数值是：" + hightFun(f1, 10))
    //使用匿名函数做参数
    val v1 = hightFun((a: Int, b: Int) => {
      a - b
    }, 10)
    println("使用了匿名函数做参数： " + v1)

    //2.函数的返回是函数
    def hightFunc2(a: Int, b: Int): (Int, Int) => Int = {
      def f2(v1: Int, v2: Int): Int = {
        v1 + v2 + a + b //这里将方法作为返回值进行了返回。
      }

      return f2 //函数作为返回值返回
    }

    //调用，求 1 2 3 4相加
    val i3 = hightFunc2(1, 2)(3, 4)
    println("函数作为返回值的结果是： " + i3)
    var f3 = hightFunc2(1, 2)
    print(f3(3, 4))

    //3. 函数的参数是函数，函数的返回是函数
    def hightFunc3(f: (Int, Int) => Int): (String, String) => String = {

      def f3(v1: String, v2: String): String = { //函数作为返回值，是为了让外部，是为了需要后来的计划，屏蔽掉过程
        var result = f(100, 10); //函数作为参数，是为了给函数使用计算的。
        return v1 + v2 + result
      }

      return f3
    }

    val str = hightFunc3((a: Int, b: Int) => {
      a + b
    })("参数一", "参数二")
    println("使用函数作为参数与返回值：   " + str)

    /**
     * 柯里化函数，高阶函数的简化。
     */
    def fun7(a :Int,b:Int)(c:Int,d:Int) = {
      a+b+c+d
    }
    println(fun7(1,2)(3,4))






  }


  //2.定义递归方法，求100倒1之间的求和计算。
  def recursion(i: Int): Int = {
    if (i > 0) recursion(i - 1) + i
    else 0
  }

  /**
   * 包含默认参数值的函数
   * 注意：
   * 1.默认值的函数中，如果传入的参数个数与函数定义相同，则传入的数值会覆盖默认值
   * 2.如果不想覆盖默认值，传入的参数个数小于定义的函数的参数，则需要指定参数名称
   */
  def Default_parameters(a: Int = 10, b: Int = 20) = {
    a + b
  }

  //4.参数可变的方法，在原有方法基础之上，添加*
  def var_para(paras: String*): Unit = {
    //==>匿名函数
    paras.foreach(ele => {
      println(ele)
    })

    //只是使用了一次，可以用_代替
    paras.foreach(println(_))

    // //或者再进行省略
    paras.foreach(println)
  }

  def printLine(): Unit = {
    println("\\n===============================================================")
  }

  def printLine(msg: String): Unit = {
    println(s"\n==========================  ${msg}  =====================================")
  }
}
