class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val mergedIntervals = mutableListOf<IntArray>()
        var i = 0
        while (i in intervals.indices && intervals[i][1] < newInterval[0]) {
            mergedIntervals.add(intervals[i])
            i++
        }
        mergedIntervals.add(newInterval)
        while (i in intervals.indices) {
            val lastInterval = mergedIntervals.last()
            if (lastInterval[1] < intervals[i][0]) {
                mergedIntervals.add(intervals[i])
            } else {
                lastInterval[0] = minOf(lastInterval[0], intervals[i][0])
                lastInterval[1] = maxOf(lastInterval[1], intervals[i][1])
            }
            i++
        }

        return mergedIntervals.toTypedArray()
    }
}
