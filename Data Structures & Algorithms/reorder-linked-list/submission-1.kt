/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        if (head == null || head.next == null) {
            return
        }

        val preMid = findPreMid(head)
        val right = preMid?.next
        preMid?.next = null

        merge(head, reverse(right))
    }

    private fun findPreMid(head: ListNode): ListNode? {
        var slow: ListNode? = ListNode(0)
        slow?.next = head
        var fast: ListNode? = head

        while (fast != null && fast.next != null) {
            fast = fast?.next
            fast = fast?.next
            slow = slow?.next
        }

        return slow
    }

    private fun reverse(head: ListNode?): ListNode? {
        var previous: ListNode? = null
        var current = head
        while (current != null) {
            val next = current.next
            current.next = previous
            previous = current
            current = next
        }

        return previous
    }

    private fun merge(headLeft: ListNode?, headRight: ListNode?): Unit {
        val dummy: ListNode? = ListNode(0)
        var current: ListNode? = dummy
        var left: ListNode? = headLeft
        var right: ListNode? = headRight

        while (left != null && right != null) {
            current?.next = left
            left = left.next
            current = current?.next
            current?.next = right
            right = right.next
            current = current?.next
        }
    }
}
