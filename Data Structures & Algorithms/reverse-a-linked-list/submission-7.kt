/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var current: ListNode? = head

        while (current != null) {
            val next: ListNode? = current.next

            current.next = prev
            prev = current
            current = next
        }

        return prev
    }
}
