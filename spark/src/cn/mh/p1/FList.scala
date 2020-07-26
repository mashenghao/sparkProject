package cn.mh.p1

import scala.collection.mutable.ListBuffer

/**
 * @program: sparkProject
 * @Date: 2020/7/25 20:25
 * @Author: mahao
 * @Description: List的操作
 */
object FList {

  def main(args: Array[String]): Unit = {

    //1. 创建一个不可变的list。
    var list1 = List[Int](1, 2, 3) //只能这样创建
    for (elem <- list1) {
      println(elem)
    }
    list1.foreach(a => {
      println(a)
    })

    //不可变，这里的.+方法是String的方法。
    val str = list1.+("aa")
    println(str)

    //2.list的map函数与切分。
    val list2 = List[String]("aa 11", "bb 22", "cc 33")
    val listResult: List[Array[String]] = list2.map((str) => {
      str.split(" ")
    })
    listResult.foreach(arr => {
      arr.foreach(a => {
        println(a)
      })
    })
    //flatMap方法。
    val strings: List[String] = list2.flatMap((str) => {
      str.split(" ")
    })
    for (elem <- strings) {
      println(elem) //将会自动切分成一行行字符串。
    }

    val list = list2.filter((a) => {
      a.equals("aa 11")
    })
    list.foreach(println(_))

    ////////////////////可变的list、、、、、、、、、、、、、
    val varList1 = ListBuffer[String]()
    varList1.append("aa")
    varList1.append("bb")
    varList1.foreach(a => {
      print(a + " ")
    })

  }
}
