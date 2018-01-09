package problem_019

import java.util

/**
  * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
  *
  * Given a linked list, remove the nth node from the end of list and return its head.
  * 给定一个链表，从列表的最后删除第n个节点并返回它的头部。
  *
  * For example,
  * Given linked list: 1->2->3->4->5, and n = 2.
  * After removing the second node from the end, the linked list becomes 1->2->3->5.
  *
  * Note:
  * Given n will always be valid. Try to do this in one pass.
  * 给定的n将永远是有效的。 尝试一次完成。
  */
object RemoveNthNodeFromEndOfList {

  def main(args: Array[String]): Unit = {
    val node = new ListNode(1)
//    node.next = new ListNode(2)
//    node.next.next = new ListNode(3)
//    node.next.next.next = new ListNode(4)
//    node.next.next.next.next = new ListNode(5)
    var newNode = removeNthFromEnd(node, 1)
    while (newNode != null) {
      println(newNode.x)
      newNode = newNode.next
    }
  }

  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    if (n == 0) {
      return head
    }
    val stack = new util.Stack[ListNode]()
    /**
      * 给链表添加一个辅助的头节点
      */
    val newNode = new ListNode()
    newNode.next = head
    var tmp = newNode
    while (tmp != null) {
      stack.push(tmp)
      tmp = tmp.next
    }

    var temp: ListNode = null
    var i = 0
    while (i < n) {
      i += 1
      val x = stack.pop()
      if (i +1 == n) {
        temp = x
      }
    }
    stack.pop().next = temp
    newNode.next
  }
}

class ListNode(var _x: Int = 0) {
  var next: ListNode = _
  var x: Int = _x
}