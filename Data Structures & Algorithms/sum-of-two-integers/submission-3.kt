class Solution {
    fun getSum(a: Int, b: Int): Int = (a xor b) + ((a and b) shl 1)
}
