package problem_015


import java.util

import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._

/**
  * https://leetcode.com/problems/3sum/description/
  *
  * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
  * 给定一个n个整数的数组S，是否存在S中的元素a，b，c，使得a + b + c = 0？查找数组中所有唯一的三元组，其总和为零。
  *
  * Note: The solution set must not contain duplicate triplets.
  * 注意：解决方案集不能包含重复的三元组。
  *
  * For example, given array S = [-1, 0, 1, 2, -1, -4],
  * A solution set is:
  * [
  * [-1, 0, 1],
  * [-1, -1, 2]
  * ]
  */
object ThreeSum {

  def main(args: Array[String]): Unit = {
    threeSum(Array(0, 0, 0, 0))
      .foreach(x => println(x.mkString(",")))
  }

  /**
    * 取一点后，剩下两点取最小和最大值，并逐渐比较移动，需要注意的是重复值的避免
    */
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    // 待优化排序
    util.Arrays.sort(nums)
    val res = new ListBuffer[List[Int]]
    for (i <- 0 until nums.length - 2) {
      // 避免重复
      if (i == 0 || nums(i) != nums(i - 1)) {
        var low = i + 1
        var high = nums.length - 1
        val sum = 0 - nums(i)
        while (low < high) {
          if (nums(low) + nums(high) == sum) {
            res.append(List(nums(i), nums(low), nums(high)))
            // 避免重复
            while (low < high && nums(low) == nums(low + 1)) low += 1
            while (low < high && nums(high) == nums(high - 1)) high -= 1
          } else if (nums(low) + nums(high) < sum) {
            // 避免重复
            while (low < high && nums(low) == nums(low + 1)) low += 1
            low += 1
          } else {
            // 避免重复
            while (low < high && nums(high) == nums(high - 1)) high -= 1
            high -= 1
          }
        }
      }
    }
    res.toList
  }


  def threeSum_2(nums: Array[Int]): List[List[Int]] = {
    // 待优化排序
    util.Arrays.sort(nums)
    val Array(zone_index_low, zone_index_high) = getZone(nums)
    val res = new ListBuffer[List[Int]]
    var i = 0
    while (i < zone_index_high) {
      // 避免重复
      if (i == 0 || nums(i) != nums(i - 1)) {
        var low = i + 1
        var high = nums.length - 1
        val sum = 0 - nums(i)
        while (low < high && low < zone_index_high && high > zone_index_low) {
          if (nums(low) + nums(high) == sum) {
            res.append(List(nums(i), nums(low), nums(high)))
            // 避免重复
            while (low < high && nums(low) == nums(low + 1)) low += 1
            while (low < high && nums(high) == nums(high - 1)) high -= 1
          } else if (nums(low) + nums(high) < sum) {
            // 避免重复
            while (low < high && nums(low) == nums(low + 1)) low += 1
            low += 1
          } else {
            // 避免重复
            while (low < high && nums(high) == nums(high - 1)) high -= 1
            high -= 1
          }
        }
      }
      i += 1
    }
    res.toList
  }

  def getZone(nums: Array[Int]): Array[Int] = {
    var zone_index_high = nums.length - 1
    var zone_index_low = 0

    for (i <- nums.indices) {
      if (nums(i) < 0) {
        zone_index_low = i
      }
      if (nums(i) > 0) {
        zone_index_high = i
        return Array(zone_index_low, zone_index_high)
      }
    }

    Array(zone_index_low, zone_index_high)
  }

  def threeSum_1(nums: Array[Int]): List[List[Int]] = {
    val sortNums = nums.sortBy(x => x)

    val res = new ListBuffer[List[Int]]

    for (i <- 0 until sortNums.length - 2) {
      /**
        * 避免重复
        */
      if (i == 0 || sortNums(i) != sortNums(i - 1)) {
        for (j <- i + 1 until sortNums.length - 1) {
          val x = sortNums(i) + sortNums(j)
          breakable {
            for (k <- j + 1 until sortNums.length) {
              val sum = sortNums(k) + x
              if (sum == 0) {
                println(s"$i - $j - $k")
                res.append(List(sortNums(i), sortNums(j), sortNums(k)))
                break
              }
              if (sum > 0) {
                break
              }
            }
          }
        }
      }
    }
    res.toList
  }


}
