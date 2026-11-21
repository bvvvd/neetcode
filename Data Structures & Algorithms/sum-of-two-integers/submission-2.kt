class Solution {
    fun getSum(a: Int, b: Int): Int {
        var l = a
        var r = b
        var sum = 0
        var carry = 0
        repeat(32) {
            val leftBit = l and 1
            val rightBit = r and 1

            sum = sum or ((leftBit xor rightBit xor carry) shl it)
            carry = (leftBit and rightBit) or (leftBit and carry) or (rightBit and carry)
            l = l shr 1
            r = r shr 1
        }

        return sum
    }
}
