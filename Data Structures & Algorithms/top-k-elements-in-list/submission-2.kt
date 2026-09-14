class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val frequencies = mutableMapOf<Int, Int>()
        nums.forEach {
            if (frequencies[it] == null) {
                frequencies[it] = 1
            } else {
                frequencies.put(it, (frequencies[it] ?: 0) + 1)
            }
        }

        val maxFrequency = frequencies.values.max()
        val groupedFrequents = Array<MutableList<Int>>(maxFrequency + 1) {mutableListOf<Int>()}
        frequencies.forEach {
            (value, frequency) -> groupedFrequents[frequency].add(value)
        }
        val topFrequent = IntArray(k)
        var n = k
        for (i in maxFrequency downTo 1) {
            groupedFrequents[i].forEach {
                topFrequent[n - 1] = it
                n--
                if (n == 0) {
                    return topFrequent
                }
            }
        }

        return topFrequent
    }
}
