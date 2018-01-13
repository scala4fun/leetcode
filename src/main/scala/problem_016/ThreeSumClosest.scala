package problem_016

import java.util


/**
  * https://leetcode.com/problems/3sum-closest/description/
  *
  * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
  * 给定一个n个整数的数组S，在S中找到三个整数，使得总和最接近给定数量的目标。
  *
  * Return the sum of the three integers. You may assume that each input would have exactly one solution.
  * 返回三个整数的和。你可以假设每个输入都只有一个解决方案。
  *
  * For example, given array S = {-1 2 1 -4}, and target = 1.
  * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
  */
object ThreeSumClosest {
  def main(args: Array[String]): Unit = {
    println(threeSumClosest(Array(1, 1, 1, 0), 100))
  }

  def threeSumClosest(nums: Array[Int], target: Int): Int = {
    util.Arrays.sort(nums)
    var res = nums(0) + nums(1) + nums(2)
    var dist = Math.abs(res - target)
    for (i <- 0 until nums.length - 2) {
      var low = i + 1
      var high = nums.length - 1
      while (low < high) {
        val sum = nums(i) + nums(low) + nums(high)
        if (Math.abs(target - sum) <= dist) {
          res = sum
          dist = Math.abs(target - res)
          if (dist == 0) {
            return res
          }
        }
        if (sum > target) {
          high -= 1
        } else {
          low += 1
        }
      }
    }
    res
  }

}
