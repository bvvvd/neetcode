class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val frequencies = IntArray(26)
        s.zip(t).forEach { (a, b) -> 
            frequencies[a - 'a']++
            frequencies[b - 'a']--
        }

        return frequencies.all { it == 0 }
    }
}
