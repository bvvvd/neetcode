class Solution {
    fun getSum(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val carry = (x and y) shl 1
            x = x xor y
            y = carry
        }
        return x
    }
}