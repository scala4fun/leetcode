package problem_003

import scala.collection.mutable

/**
  * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
  *
  * Given a string, find the length of the longest substring without repeating characters.
  * 给定一个字符串，找到最长的没有重复字符的子字符串的长度。
  *
  * Examples:
  * Given "abcabcbb", the answer is "abc", which the length is 3.
  * Given "bbbbb", the answer is "b", with the length of 1.
  * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
  */
object LongestSubstringWithoutRepeatingCharacters {
  def lengthOfLongestSubstring(s: String): Int = {
    val n = s.length
    val set = new mutable.HashSet[Character]()
    var ans = 0
    var i = 0
    var j = 0

    /**
      * 该算法i、j初始位置在0处，先移动j，直到出现重复，再移动i
      *
      * 时间复杂度 O(n)
      */
    while (i < n && j < n) {
      if (!set.contains(s.charAt(j))){
        set.add(s.charAt(j))
        j += 1
        ans = Math.max(ans, j - i)
      } else {
        set.remove(s.charAt(i))
        i += 1
      }
    }
    ans
  }
}
