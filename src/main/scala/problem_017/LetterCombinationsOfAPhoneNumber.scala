package problem_017

/**
  * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
  *
  * Given a digit string, return all possible letter combinations that the number could represent.
  * 给定一个数字字符串，返回数字可能表示的所有可能的字母组合。
  *
  * A mapping of digit to letters (just like on the telephone buttons) is given below.
  * 数字到字母的映射（就像电话按钮一样）在下面给出。
  * http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png
  *
  * Input:Digit string "23"
  * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
  *
  * Note: 虽然上面的答案是按照字典顺序排列的，但是你的答案可以是你想要的任何顺序。
  */
object LetterCombinationsOfAPhoneNumber {

  def main(args: Array[String]): Unit = {
    letterCombinations("").foreach(println)
  }

  def letterCombinations(digits: String): List[String] = {
    if (digits.length == 0) {
      List.empty[String]
    } else {
      letterCombinations(digits, 0)
    }
  }

  /**
    * 递归拼接
    */
  def letterCombinations(digits: String, i: Int): List[String] = {
    if (i >= digits.length) {
      List("")
    } else {
      letter(digits, i).flatMap(a => letterCombinations(digits, i + 1).map(b => a + b))
    }
  }

  def letter(digits: String, i: Int) = {
    digits.charAt(i).toString match {
      case "2" => List("a", "b", "c")
      case "3" => List("d", "e", "f")
      case "4" => List("g", "h", "i")
      case "5" => List("j", "k", "l")
      case "6" => List("m", "n", "o")
      case "7" => List("p", "q", "r", "s")
      case "8" => List("t", "u", "v")
      case "9" => List("w", "x", "y", "z")
      case _ => List("")
    }
  }
}
