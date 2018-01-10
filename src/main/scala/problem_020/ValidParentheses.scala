package problem_020

import java.util

/**
  * https://leetcode.com/problems/valid-parentheses/description/
  *
  * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
  * 给定一个只包含字符'（'，'）'，'{'，'}'，'['和']'的字符串，确定输入字符串是否有效。
  *
  * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
  * 括号必须以正确的顺序关闭，“()”和“(){}[]”全部有效，但“(]”和“({)}”不是。
  *
  *
  */
object ValidParentheses {

  def main(args: Array[String]): Unit = {
    println(isValid("()"))
    println(isValid("(){}[]"))
    println(isValid("({)}"))
  }

  /**
    * 通过一个stack保证符号是成对的，需要注意的是各种情况的处理
    */
  def isValid(s: String): Boolean = {
    if (s == null || s.length % 2 != 0) {
      return false
    }
    val stack = new util.Stack[String]()
    for (i <- 0 until s.length) {
      val c = s.charAt(i).toString
      if (c == "(" || c == "[" || c == "{") {
        stack.push(c)
      } else {
        if (stack.empty()) {
          return false
        }
        val x = stack.pop()
        if (c == ")" && x != "(") {
          return false
        } else if (c == "]" && x != "[") {
          return false
        } else if (c == "}" && x != "{") {
          return false
        }
      }
    }
    if (!stack.empty()) return false
    true
  }
}
