package problem_005

/**
  * https://leetcode.com/problems/longest-palindromic-substring/description/
  *
  * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
  * 给定一个字符串s，找到s中最长的回文子字符串。 你可以假定s的最大长度是1000。
  *
  * Example:
  * Input: "babad"
  * Output: "bab"
  * Note: "aba" is also a valid answer.
  *
  * Example:
  * Input: "cbbd"
  * Output: "bb"
  */
object LongestPalindromicSubstring {

  def main(args: Array[String]): Unit = {
    println(longestPalindrome("bb"))
  }


  var currLength = 0
  var res = ""

  def longestPalindrome(s: String): String = {
    if (s.length == 1) {
      return s
    }
    for (i <- 0 until s.length) {
      // 131类型的
      getLongPalindrome(s, i, i)
      // 1331类型的
      getLongPalindrome(s, i, i + 1)
    }
    res
  }


  /**
    * 从中心点向外判断是否为回文
    */
  def getLongPalindrome(c: String, _low: Int, _high: Int): Unit = {
    var low = _low
    var high = _high
    while (low >= 0 && high < c.length) {
      if (c.charAt(low) == c.charAt(high)) {
        if (currLength < high - low + 1) {
          res = c.substring(low, high + 1)
          currLength = high - low + 1
        }
        low -= 1
        high += 1
      } else {
        return
      }
    }
  }




  /**
    * https://discuss.leetcode.com/topic/21848/ac-relatively-short-and-very-clear-java-solution 题解
    */
//  def longestPalindrome(s: String): String = {
//    var res = ""
//    var currLength = 0
//    for (i <- 0 until s.length) {
//      if (isPalindromic(s, i - currLength - 1, i)) {
//        res = s.substring(i - currLength - 1, i + 1)
//        currLength = currLength + 2
//      } else if (isPalindromic(s, i - currLength, i)) {
//        res = s.substring(i - currLength, i + 1)
//        currLength = currLength + 1
//      }
//    }
//    res
//  }
//
//  /**
//    * 判断是否为回文字符串
//    *
//    * @return
//    */
//  def isPalindromic(s: String, _begin: Int, _end: Int): Boolean = {
//    var begin = _begin
//    var end = _end
//    if (begin < 0) return false
//    while (begin < end) {
//      if (s.charAt(begin) != s.charAt(end)) return false
//      begin += 1
//      end -= 1
//    }
//    true
//  }
}
