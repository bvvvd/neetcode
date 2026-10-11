class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy{ it[0] }
        val mergedIntervals = mutableListOf<IntArray>()
        intervals.forEach {
            if (mergedIntervals.isEmpty()) {
                mergedIntervals.add(it)
            } else if (mergedIntervals.last()[1] < it[0]) {
                mergedIntervals.add(it)
            } else {
                val previous = mergedIntervals.last()
                previous[0] = minOf(previous[0], it[0])
                previous[1] = maxOf(previous[1], it[1])
            }
        }

        return mergedIntervals.toTypedArray()
    }
}
