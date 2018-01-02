package problem_001

/**
  * https://leetcode.com/problems/two-sum/description/
  *
  * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
  * 给定一个整数数组，返回两个数字的索引，使它们加起来成为一个特定的目标。
  * You may assume that each input would have exactly one solution, and you may not use the same element twice.
  * 假设：每个输入都只有一个解决方案，且不会使用相同的元素两次。
  *
  * Example:
  * Given nums = [2, 7, 11, 15], target = 9,
  * *
  * Because nums[0] + nums[1] = 2 + 7 = 9,
  * return [0, 1].
  *
  */
object TwoSum {
  def main(args: Array[String]): Unit = {
    println(twoSum(Array(3, 2, 4), 6))
  }

  /**
    * 很简单的题目，需要考虑的就是避免比较过的数字重复比较
    */
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    for (i <- nums.indices) {
      val x = target - nums(i)
      for (j <- i + 1 until nums.length) {
        if (x == nums(j)) {
          return Array(i, j)
        }
      }
    }
    throw new Exception("index not found")
  }
}
