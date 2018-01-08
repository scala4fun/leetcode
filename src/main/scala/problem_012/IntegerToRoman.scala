package problem_012

/**
  * https://leetcode.com/problems/integer-to-roman/description/
  *
  * Given an integer, convert it to a roman numeral.
  * 给定一个整数，将其转换为罗马数字。
  *
  * Input is guaranteed to be within the range from 1 to 3999.
  * 输入保证在1到3999的范围内。
  *
  */
object IntegerToRoman {

  def main(args: Array[String]): Unit = {
    println(intToRoman(99))
  }

  /**
    * 首先弄清楚什么是罗马数字: https://zh.wikipedia.org/wiki/%E7%BD%97%E9%A9%AC%E6%95%B0%E5%AD%97
    */
  def intToRoman(num: Int): String = {
    val M = Array("", "M", "MM", "MMM")
    val C = Array("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
    val X = Array("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
    val I = Array("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")
    M(num / 1000) + C((num % 1000) / 100) + X((num % 100) / 10) + I(num % 10)
  }
}
