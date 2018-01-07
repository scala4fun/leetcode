package problem_006

/**
  * https://leetcode.com/problems/zigzag-conversion/description/
  *
  * "PAYPALISHIRING" 字段按照给予的行数，以Zigzag的形式书写。Zigzag就是Z字形。
  *
  * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
  *
  * P   A   H   N
  * A P L S I I G
  * Y   I   R
  *
  * 然后输出得到 "PAHNAPLSIIGYIR"
  * And then read line by line: "PAHNAPLSIIGYIR"
  *
  * Write the code that will take a string and make this conversion given a number of rows:
  *
  * string convert(string text, int nRows);
  *
  * convert("PAYPALISHIRING", 3) 应该返回 "PAHNAPLSIIGYIR"
  * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
  *
  * 这道题目是一道随着row的变化找规律的题目,一个不在斜线上的规律，还有一个在斜线上的规律
  *
  */
object ZigZagConversion {
  def main(args: Array[String]): Unit = {
    println(convert("PAYPALISHIRING", 3))
  }

  def convert(s: String, numRows: Int): String = {
    numRows match {
      case 1 => s
      case n if n > 1 => {
        val lengthPerCycle = 2*numRows - 2
        val cycles = (s.length / lengthPerCycle) + 1
        val sb = new StringBuilder
        for (i <- 0 until numRows) {
          for (cycle <- 0 until cycles) {
            // print full vertical
            val col = (cycle*lengthPerCycle)+i
            if (col < s.length)
              sb.append(s(col))
            // print diagonal
            val dia = ((cycle+1)*lengthPerCycle)-i
            if (i != 0 && i < numRows - 1 && dia < s.length)
              sb.append(s(dia))
          }
        }
        sb.toString()
      }
      case _ => throw new Error("negative number")
    }
  }
}
