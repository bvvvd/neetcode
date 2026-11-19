class Solution {
    fun reverseBits(n: Int): Int {
        var number = n
        var reversed = 0

        repeat(32) {
            reversed = (reversed shl 1) or (number and 1)
            number = number ushr 1
        }

        return reversed
    }
}