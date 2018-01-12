package problem_029

/**
  * https://leetcode.com/problems/divide-two-integers/description/
  *
  * Divide two integers without using multiplication, division and mod operator.
  * 不用乘法，除法和mod运算符来实现两个整数的除法。
  *
  * If it is overflow, return MAX_INT.
  * 如果溢出，则返回MAX_INT。
  *
  *
  */
object DivideTwoIntegers {

  def main(args: Array[String]): Unit = {
    println(divide(-2147483648, 2))
  }

  /**
    * 整数，包含正数、负数、0。需要考虑的是这些情况的处理
    */
  def divide(dividend: Int, divisor: Int): Int = {
    -1
  }
}
