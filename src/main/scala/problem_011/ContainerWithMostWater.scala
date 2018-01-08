package problem_011

/**
  * https://leetcode.com/problems/container-with-most-water/description/
  *
  * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
  * 给定n个非负整数a1，a2，...，an，其中每个代表坐标（i，ai）处的一个点。
  *
  * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
  * 绘制n条垂直线，线i的两个端点处于（i，ai）和（i，0）处。
  *
  * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
  * 找到两条线，它们与x轴一起形成一个容器，使得容器包含最多的水。
  *
  * Note: You may not slant the container and n is at least 2.
  * 注意：你可能不倾斜容器，n至少为2。
  *
  */
object ContainerWithMostWater {

  def main(args: Array[String]): Unit = {
    println(maxArea_2(Array(3, 1, 2, 3, 1)))
  }

  /**
    * 从外向内，面积受最短边和两个边的距离影响
    */
  def maxArea_2(height: Array[Int]): Int = {
    var low = 0
    var high = height.length - 1
    var max = 0
    while (high > low) {
      val x = high - low
      val y = Math.min(height(high), height(low))
      max = Math.max(max, x * y)

      if (height(high) > height(low)) {
        low += 1
      } else {
        high -= 1
      }

    }
    max
  }

  /**
    * 暴力遍历: O(n^2)
    **/
  def maxArea_1(height: Array[Int]): Int = {
    var max = 0
    for (i <- height.indices) {
      for (j <- i + 1 until height.length) {
        val y = Math.min(height(i), height(j))
        val x = Math.abs(j - i)
        max = Math.max(max, x * y)
      }
    }
    max
  }

}
