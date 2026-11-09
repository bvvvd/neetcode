class Solution {
    fun countBits(n: Int): IntArray {
        val bits = IntArray(n + 1)
        var power = 1
        for (i in 1..n) {
            if (power * 2 == i) {
                power = i
            }
            bits[i] = bits[i - power] + 1
        }
        return bits
    }
}
