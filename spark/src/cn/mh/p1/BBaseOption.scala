package cn.mh.p1

/**
 * @program: sparkProject
 * @Date: 2020/7/23 0:40
 * @Author: mahao
 * @Description: scala的基本流程
 */
object BBaseOption {

  def main(args: Array[String]): Unit = {

    //1.if-else,可以结果直接赋值
    val a = 10
    val b =
      if (a < 10) -1
      else if (a > 10) 1
      else 0

    //2.循环
    val range1 = 1.to(10, 2)
    val range2 = 1 until 10
    println(range1)
    println(range2)
    //to是scala中的操作符，可以替换为方法。
    for (i <- 1 to 10 by 2)
      print(i + "  ")

    for (i <- 1.until(10, 1); j <- 1.until(10, 1)) {
      print(i * j + "  ")
    }

    for (i <- 1 to 100 if (i % 2 == 0) if (i < 10)) { //循环条件用if，可以有多个

    }
    //3.yield,拿到符合条件的结合。
    val result = for (i <- 1 to 100 if (i % 2 == 0)) yield i
    println(result)



  }
}
