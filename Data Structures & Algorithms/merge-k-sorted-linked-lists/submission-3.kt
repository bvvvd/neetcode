/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) {
            return null
        }
        var step = 1
        while (`step` < lists.size) {
            for (i in 0 until (lists.size - `step`) step `step`*2) {
                lists[i] = merge(lists[i], lists[i + `step`])
            }
            `step` *= 2
        }

        return lists[0]
    }

    private fun merge(l: ListNode?, r: ListNode?): ListNode? {
        var left: ListNode? = l
        var right: ListNode? = r
        val dummy = ListNode(0)
        var current: ListNode? = dummy
        while (left != null && right != null) {
            if (left.`val` <= right.`val`) {
                current?.next = left
                left = left.next
                current = current?.next
            } else {
                current?.next = right
                right = right.next
                current = current?.next
            }
        }

        current?.next = if (left == null) right else left
        return dummy.next
    }
}
