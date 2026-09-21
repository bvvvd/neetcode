class Solution {
    fun minWindow(s: String, t: String): String {
        if (t.length > s.length) {
            return ""
        }
        val requiredFrequencies = mutableMapOf<Char, Int>()
        for (c in t) {
            requiredFrequencies[c] = requiredFrequencies.getOrDefault(c, 0) + 1
        }

        var minLength = Int.MAX_VALUE
        val substringIndices = IntArray(2)

        var left = 0
        val windowFrequencies = mutableMapOf<Char, Int>()
        for (right in s.indices) {
            windowFrequencies[s[right]] = windowFrequencies.getOrDefault(s[right], 0) + 1
            
            while (windowFrequencies.includes(requiredFrequencies)) {        //
                if (right - left + 1 < minLength) {                          //
                    minLength = right - left + 1                             //
                    substringIndices[0] = left                               //
                    substringIndices[1] = right                              //
                }
                windowFrequencies[s[left]] = windowFrequencies.getOrDefault(s[left], 0) - 1  //
                left++                                                       //
            }
        }

        return if (minLength == Int.MAX_VALUE) "" else s.substring(substringIndices[0], substringIndices[1] + 1)
    }

    private fun MutableMap<Char, Int>.includes(other: MutableMap<Char, Int>): Boolean {
        for ((c, count) in other) {
            if (this.getOrDefault(c, 0) < count) return false
        }
        return true
    }
}
