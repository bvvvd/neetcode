class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0

        val sortedIntervals = intervals.sortedBy { it[1] }
        var end = sortedIntervals[0][1]
        var erasedCount = 0
        for (i in 1 until sortedIntervals.size) {
            if (sortedIntervals[i][0] >= end) {
                end = sortedIntervals[i][1]
            } else {
                erasedCount++
            }
        }

        return erasedCount
    }
}
