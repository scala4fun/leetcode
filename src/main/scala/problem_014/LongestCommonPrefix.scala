package problem_014

/**
  * https://leetcode.com/problems/longest-common-prefix/description/
  *
  * Write a function to find the longest common prefix string amongst an array of strings.
  * 编写一个函数来查找字符串数组中最长的公共前缀字符串。
  *
  */
object LongestCommonPrefix {

  def main(args: Array[String]): Unit = {
    println(longestCommonPrefix(Array("a", "a")))
  }

  /**
    * 思路就是挨个比较一下前缀，并渐渐缩小前缀范围，需要注意的是边界check
    */
  def longestCommonPrefix(strs: Array[String]): String = {
    if (strs.length == 0) {
      return ""
    }
    if (strs.length == 1) {
      return strs(0)
    }
    var index = Math.min(strs(0).length, strs(1).length)
    for (i <- 0 until strs.length - 1) {
      index = commonPrefix(strs(i), strs(i + 1), index)
      if (index == 0) {
        return ""
      }
    }
    strs(0).substring(0, index)
  }

  /**
    * 找公共前缀
    *
    * @param a     ,b 待查找的两个字符串
    * @param index 限定的范围
    * @return
    */
  def commonPrefix(a: String, b: String, index: Int): Int = {
    val _index = Math.min(b.length, index)
    for (i <- 0 until _index) {
      if (a.charAt(i) != b.charAt(i)) {
        return i
      }
    }
    _index
  }
}
