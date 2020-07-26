package cn.mh.p1

import scala.collection.generic.GenericCompanion

/**
 * @program: sparkProject
 * @Date: 2020/7/25 21:56
 * @Author: mahao
 * @Description:
 */
object DMap {
  def main(args: Array[String]): Unit = {

    val map1 = Map[String, String]("a" -> "aa", "b" -> "bb")

    //map的值的返回值，是Option
    val option1: Option[String] = map1.get("a")
    val option2: Option[String] = map1.get("e")
    println("option1的值是： " + option1 + "  结果值是：" + option1.get)
    println("option2的值是不存在这个值： " + option2 + "  结果值是：" + option2.getOrElse("默认值"))

    map1.foreach((e) => {
      val k = e._1
      val v = e._2
      println(k + "   " + v)
    })
    val it: Iterable[String] = map1.keys
    for (elem <- it) {
      println(elem + " ")
    }
  }
}
