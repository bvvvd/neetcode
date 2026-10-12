/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        val sortedIntervals = intervals.sortedBy{ it.start }
        val heap = PriorityQueue<Int>()
        var maxRooms = 0
        sortedIntervals.forEach {
            while (heap.isNotEmpty() && heap.peek() <= it.start) {
                heap.poll()
            }
            heap.add(it.end)
            maxRooms = maxOf(maxRooms, heap.size)
        }

        return maxRooms
    }
}
