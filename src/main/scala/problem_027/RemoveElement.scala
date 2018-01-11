package problem_027

/**
  * https://leetcode.com/problems/remove-element/description/
  *
  * Given an array and a value, remove all instances of that value in-place and return the new length.
  * 给定一个数组和一个值，就地删除该值的所有实例并返回新的长度。
  *
  * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
  * 不要为其他数组分配额外的空间，您必须通过在O（1）额外的内存中就地修改输入数组来实现这一点。
  *
  * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
  *
  * Example:
  * Given nums = [3,2,2,3], val = 3,
  * Your function should return length = 2, with the first two elements of nums being 2.
  */
object RemoveElement {
  def main(args: Array[String]): Unit = {
    val nums = Array(3,2,2,3)
    val len = removeElement(nums, 3)
    println(s"len => $len")
    println(s"nums => ${nums.mkString(",")}")

  }
  def removeElement(nums: Array[Int], `val`: Int): Int = {
    var len = 0
    for (i <- nums.indices) {
      if (nums(i) != `val`) {
        nums(len) = nums(i)
        len += 1
      }
    }
    len
  }
}
