class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val frequencies = IntArray(26)
        for (i in s.indices) {
            frequencies[s[i] - 'a']++
            frequencies[t[i] - 'a']--
        }

        return frequencies.all { it == 0 }
    }
}
