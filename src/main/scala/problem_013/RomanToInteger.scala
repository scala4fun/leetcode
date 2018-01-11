package problem_013

/**
  * https://leetcode.com/problems/roman-to-integer/description/
  *
  * Given a roman numeral, convert it to an integer.
  * 给定一个罗马数字，将其转换为整数。
  *
  * Input is guaranteed to be within the range from 1 to 3999.
  * 输入保证在1到3999的范围内。
  *
  */
object RomanToInteger {

  def main(args: Array[String]): Unit = {
    println(romanToInt("I")) // 1
    println(romanToInt("XIII")) // 13
    println(romanToInt("CXCIX")) // 199
    println(romanToInt("MCDXXXVII")) // 1437
    println(romanToInt("MMMCCCXXXIII")) // 3333
  }

  /**
    * 从最小的开始，遇到比自己更小的就减去他
    */
  def romanToInt(s: String): Int = {
    val map: Map[String, Int] = Map("M" -> 1000, "D" -> 500, "C" -> 100, "L" -> 50, "X" -> 10, "V" -> 5, "I" -> 1)
    var tmp = 1
    var sum = 0
    for (i <- s.length -1 to 0 by -1){
      val c: Int = map(s.charAt(i).toString)
      if (tmp > c) {
        sum -= c
      } else {
        sum += c
      }
      tmp = c
    }
    sum
  }
}
