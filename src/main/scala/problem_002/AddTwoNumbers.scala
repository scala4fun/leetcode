package problem_002

/**
  * https://leetcode.com/problems/add-two-numbers/description/
  *
  * You are given two non-empty linked lists representing two non-negative integers.
  * 给你两个非空链表，表示两个非负整数。
  * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
  * 数字以相反的顺序存储，每个节点包含一个数字。 添加这两个数字并将其作为链接列表返回。
  *
  * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
  * 您可以假定这两个数字不包含任何前导零，除了数字0本身。
  *
  * Example:
  * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
  * Output: 7 -> 0 -> 8
  * Explanation: 342 + 465 = 807.
  */
object AddTwoNumbers {

  def main(args: Array[String]): Unit = {
    val l1 = new ListNode(2)
    l1.next = new ListNode(4)
    l1.next.next = new ListNode(3)

    val l2 = new ListNode(5)
    l2.next = new ListNode(6)
    l2.next.next = new ListNode(4)

    var result = addTwoNumbers(l1, l2)
    while (result != null) {
      println(result.x)
      result = result.next
    }
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var tmpNode: ListNode = new ListNode(0)
    var tmp1 = l1
    var tmp2 = l2
    val startNode: ListNode = tmpNode

    var tmp = 0
    while (tmp1 != null || tmp2 != null || tmp != 0) {
      val x1 = if (tmp1 == null) 0 else tmp1.x
      val x2 = if (tmp2 == null) 0 else tmp2.x
      val sum = tmp + x1 + x2
      tmp = sum / 10

      tmpNode.next = new ListNode(sum % 10)
      tmpNode = tmpNode.next

      /**
        * 注意空指针
        */
      if (tmp1 != null) tmp1 = tmp1.next
      if (tmp2 != null) tmp2 = tmp2.next

    }

    /**
      * 头部初始化的0，用于避免多余的判断
      */
    startNode.next
  }
}

class ListNode(var _x: Int = 0) {
  var next: ListNode = _
  var x: Int = _x
}