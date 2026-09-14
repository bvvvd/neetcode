class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val frequencies = mutableMapOf<Int, Int>()
        nums.forEach {
            frequencies.merge(it, 1, Int::plus)
        }
        val groupedFrequents = Array<MutableList<Int>>(nums.size + 1) {mutableListOf<Int>()}
        frequencies.forEach {
            (value, frequency) -> groupedFrequents[frequency].add(value)
        }
        val topFrequent = IntArray(k)
        var n = k
        for (i in nums.size downTo 1) {
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
