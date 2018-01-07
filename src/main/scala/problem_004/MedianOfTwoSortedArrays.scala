package problem_004

/**
  * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
  *
  * There are two sorted arrays nums1 and nums2 of size m and n respectively.
  * 有两个大小为m和n的排序数组nums1和nums2。
  *
  * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
  * 找到两个排序数组的中位数。整体运行时间复杂度应该是O(log(m+n))
  *
  *
  *
  * Example 1:
  * nums1 = [1, 3]
  * nums2 = [2]
  *
  * The median is 2.0
  *
  * Example 2:
  * nums1 = [1, 2]
  * nums2 = [3, 4]
  *
  * The median is (2 + 3)/2 = 2.5
  *
  *
  */
object MedianOfTwoSortedArrays {

  def main(args: Array[String]): Unit = {
    println(findMedianSortedArrays_2(Array(1, 1), Array(1, 1)))
  }



  /**
    * 先确定索引，再通过找小值来达到按顺序查找
    */
  def findMedianSortedArrays_2(nums1: Array[Int], nums2: Array[Int]): Double = {
    var x = 0
    var y = 0
    val size = nums1.length + nums2.length
    val index_a = size / 2 + 1
    val index_b = if (size % 2 == 0) index_a - 1 else index_a

    var value_a = 0
    var value_b = 0

    while (x + y < index_a) {
      val result = if (x > nums1.length - 1) {
        y += 1
        nums2(y - 1)
      } else if (y > nums2.length - 1) {
        x += 1
        nums1(x - 1)
      } else {
        if (nums1(x) > nums2(y)) {
          y += 1
          nums2(y - 1)
        } else {
          x += 1
          nums1(x - 1)
        }
      }

      val step = x + y

      if (step == index_a) {
        value_a = result
      }

      if (step == index_b) {
        value_b = result
      }
    }
    (value_a + value_b) / 2.0
  }


  /**
    * 官方题解，无法通过 [1,1] , [1,1] 用例
    */
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    var m = nums1.length
    var n = nums2.length
    var A = nums1
    var B = nums2

    if (m > n) {
      val temp = A
      A = B
      B = temp

      val tmp = m
      m = n
      n = tmp
    }

    var iMin = 0
    var iMax = m
    val halfLen = (m + n + 1) / 2

    while (iMin <= iMax) {
      val i = (iMin + iMax) / 2
      val j = halfLen - i

      if (i < iMax && B(j - 1) > A(i)) {
        iMin += 1
      } else if (i > iMax && A(i - 1) > B(j)) {
        iMax -= 1
      } else {
        var maxLeft = 0
        if (i == 0) {
          maxLeft = B(j - 1)
        } else if (j == 0) {
          maxLeft = A(i - 1)
        } else {
          maxLeft = Math.max(A(i - 1), B(j - 1))
        }

        if ((m + n) % 2 == 1) {
          return maxLeft
        }

        var minRight = 0
        if (i == m) {
          minRight = B(j)
        } else if (j == n) {
          minRight = A(i)
        } else {
          maxLeft = Math.min(A(i), B(j))
        }
        return (maxLeft + minRight) / 2.0
      }
    }
    0.0
  }
}
