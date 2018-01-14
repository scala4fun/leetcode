package problem_007

import problem_006.ZigZagConversion.convert

/**
  * 给一个32位的整数，反转整数
  * Given a 32-bit signed integer, reverse digits of an integer.
  **
  *Example 1:
  **
  *Input: 123
  *Output:  321
  *Example 2:
  **
  *Input: -123
  *Output: -321
  *Example 3:
  **
 *Input: 120
  *Output: 21
  */
object ReverseInteger {
  def main(args: Array[String]): Unit = {
    System.out.print(reverse(-123))
  }

  def reverse(x: Int): Int = {
    def reverset(x : Int, acc : Int =0):Int = {
      if(x == 0)
        acc
      else{
        if(Math.abs(Int.MaxValue / 10)  < Math.abs(acc)) 0 else
          reverset(x/10,acc*10+(x%10))
      }
    }

    reverset(x)
  }
}
