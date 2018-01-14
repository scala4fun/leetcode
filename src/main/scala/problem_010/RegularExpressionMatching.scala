package problem_010

/**
  * 实现正则表达式支持 '.'和'*'
  * Implement regular expression matching with support for '.' and '*'.
  *
  *
  * '.' Matches any single character.
  * '*' Matches zero or more of the preceding element.
  * *
  * The matching should cover the entire input string (not partial).
  * *
  * The function prototype should be:
  * bool isMatch(const char *s, const char *p)
  * *
  * Some examples:
  * isMatch("aa","a") → false
  * isMatch("aa","aa") → true
  * isMatch("aaa","aa") → false
  * isMatch("aa", "a*") → true
  * isMatch("aa", ".*") → true
  * isMatch("ab", ".*") → true
  * isMatch("aab", "c*a*b") → true
  *
  *
  */
object RegularExpressionMatching {
  def main(args: Array[String]): Unit = {

    println(isMatch("aa", "a*"))
  }

  def isMatch(s: String, p: String): Boolean = {
    if (p.isEmpty()) {
      return s.isEmpty
    }

    if (p.size == 1) {
      return (s.size == 1) && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
    }
    if (p.charAt(1) != '*') {
      if (s.size == 0) {
         false
      } else {
         (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
      }
    } else {
      var _s=s
      while (_s.size > 0 && ((p.charAt(0) == _s.charAt(0) || (p.charAt(0) == '.')))) {
        if (isMatch(_s, p.substring(2))) {
          return true
        }
        _s = _s.substring(1)
      }
      return isMatch(_s, p.substring(2))
    }


  }
}
