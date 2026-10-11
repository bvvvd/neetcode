class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val mergedIntervals = mutableListOf<IntArray>()
        var (start, end) = newInterval
        var i = 0
        while (i < intervals.size && intervals[i][1] < start) {
            mergedIntervals.add(intervals[i])
            i++
        }
        while (i < intervals.size && intervals[i][0] <= end) {
            start = minOf(start, intervals[i][0])
            end = maxOf(end, intervals[i][1])
            i++
        }
        mergedIntervals.add(intArrayOf(start, end))
        while (i < intervals.size) {
            mergedIntervals.add(intervals[i])
            i++
        }

        return mergedIntervals.toTypedArray()
    }
}
