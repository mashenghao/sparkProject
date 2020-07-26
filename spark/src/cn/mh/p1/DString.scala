package cn.mh.p1

/**
 * @Date: 2020/7/23 17:46
 * @Author: mahao
 * @Description: scala字符串
 * 1. String
 * 2.StringBuild可变
 * 3.string操作方法
 *
 *
 *
 */
object DString {

  def main(args: Array[String]): Unit = {
    //1.根据assci吗查找位置
    val aa = "abcd"
    val AA = "ABCD"
    val bb = "abcd"

    println(aa.indexOf(98))
    println(aa == AA) //false
    println(aa == "abcd")
    println(aa == bb)

    /**
     * compareToIgnoreCase
     *
     * 如果参数字符串等于此字符串，则返回值 0；
     * 如果此字符串小于字符串参数，则返回一个小于 0 的值；
     * 如果此字符串大于字符串参数，则返回一个大于 0 的值。
     *
     */
    println(aa.equalsIgnoreCase(AA))

    //aa的值 没有改变
    println(aa + "cc")
    println(aa)

    //可变的字符
    var sb = new StringBuilder()
    sb.append("abc")
    sb + 'd'
    sb ++= "efg"
    println(sb)
  }
}
