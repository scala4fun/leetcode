package problem_026

/**
  * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
  *
  * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
  * 给定一个有序数组，删除重复内容，使每个元素只出现一次，并返回新的长度。
  *
  * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
  * 不要为数组分配其他额外的空间，您必须通过在O（1）额外的内存中就地修改输入数组来实现这一点。
  *
  * Example:
  * Given nums = [1,1,2],
  * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.It doesn't matter what you leave beyond the new length.
  */
object RemoveDuplicatesFromSortedArray {
  def main(args: Array[String]): Unit = {
    println(removeDuplicates(Array(1, 2, 3, 3, 4, 5))) //5
    println(removeDuplicates(Array(3, 3, 3, 3, 3))) //3
    println(removeDuplicates(Array(1, 1, 2))) //2
  }

  def removeDuplicates(nums: Array[Int]): Int = {
    if (nums.length <= 1) {
      return nums.length
    }
    var len = 1
    for (i <- 1 until nums.length) {
      if (nums(i) != nums(i - 1)) {
        len += 1
      }
    }
    len
  }
}
