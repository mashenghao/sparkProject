package cn.mh.p1

import scala.collection.mutable.ArrayBuffer

/**
 * @program: sparkProject
 * @Date: 2020/7/23 18:13
 * @Author: mahao
 * @Description: 数组
 */
object EArray {

  def main(args: Array[String]): Unit = {
    //1.创建数组
    var arr1 = new Array[Int](10)
    //2.Array是object，为什么可以指定呢。
    // 这里是将Array直接赋值给了arr2变量，但是因为apply的存在，所以可以赋值。
    var arr2 = Array[String]("aa", "bb", "cc")

    //2.赋值
    arr1(0) = 100

    println(arr1.length)
    println(arr2)
    arr2.foreach((a: String) => {
      println(a)
    });

    //3.二位数组的的创建，创建10行的数组。
    var arr3 = new Array[Array[String]](3);
    arr3(0) = Array[String]("1", "2", "3");
    arr3(1) = Array[String]("4", "5", "6");
    arr3(2) = Array[String]("7", "8", "9");
    //打印
    arr3.foreach((arr) => {
      arr.foreach(a => println(a))
    })

    ///////////////////可变数组////////////////
    var arr5 = new ArrayBuffer[String]()
    var arr6 = ArrayBuffer[Any]("1", "2", 2)
    arr5.+=("bb")
    arr5.+=:("aa")
    arr5.append("cc")

    for (a <- arr5 if (a != null)) {
      println(a)
    }
  }
}
