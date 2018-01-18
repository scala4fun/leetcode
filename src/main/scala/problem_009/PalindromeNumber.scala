package problem_009

/**
  * 判断一个整数是不是回文
  * Determine whether an integer is a palindrome. Do this without extra space.
  */
object PalindromeNumber {
  def main(args: Array[String]): Unit = {
    println(isPalindrome(1221))
  }

  def isPalindrome(x: Int): Boolean = {
    if (x < 0 || x % 10 == 0 && x !=0) return false
    // 将前面一半位数的数值倒过来
    var y = x
    var tmp = 0
    while (y > tmp) {
      tmp = tmp * 10 + y % 10
      y = y / 10
    }
    // 位数为偶数 与 位数为奇数的情况
    y == tmp || y == tmp / 10
  }

}
