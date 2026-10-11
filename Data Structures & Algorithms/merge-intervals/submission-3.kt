class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val sourceIntervals = intervals.sortedBy{ it[0] }
        val mergedIntervals = mutableListOf<IntArray>()
        for ((start, end) in sourceIntervals) {
            if (mergedIntervals.isEmpty() || mergedIntervals.last()[1] < start) {
                mergedIntervals.add(intArrayOf(start, end))
            } else {
                val previous = mergedIntervals.last()
                previous[1] = maxOf(previous[1], end)
            }
        }

        return mergedIntervals.toTypedArray()
    }
}
