package problem_009

/**
  * 判断一个整数是不是回文
  * Determine whether an integer is a palindrome. Do this without extra space.
  */
object PalindromeNumber {
  def main(args: Array[String]): Unit = {
    isPalindrome("1221")
  }
  def isPalindrome(someNumber:String):Boolean = {
    val len = someNumber.length;
    for(i <- 0 until len/2) {
      if(someNumber(i) != someNumber(len-i-1)) return false;
    }
    return true;
  }

}
