package problem_028

/**
  * https://leetcode.com/problems/implement-strstr/description/
  *
  * Implement strStr(). http://www.cplusplus.com/reference/cstring/strstr/
  *
  * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
  *
  * 在haystack中返回needle的索引，如果needle不是haystack的一部分，则返回-1。
  *
  * Example 1:
  * Input: haystack = "hello", needle = "ll"
  * Output: 2
  *
  * Example 2:
  * Input: haystack = "aaaaa", needle = "bba"
  * Output: -1
  */
object ImplementStrStrFunc {
  def main(args: Array[String]): Unit = {
    println(strStr("hello", "ll"))
    println(strStr("hello", "llo"))
    println(strStr("aaaaa", "bba"))
  }

  /**
    * 没有考虑什么简单的方法 = = ，也许可以参考一下indexOf函数
    */
  def strStr(haystack: String, needle: String): Int = {
    val size = needle.length
    for (i <- 0 to haystack.length - size) {
      if (haystack.substring(i, size + i).equals(needle)) {
        return i
      }
    }
    -1
  }


}
