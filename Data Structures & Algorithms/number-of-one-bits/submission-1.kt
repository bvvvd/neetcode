class Solution {
    fun hammingWeight(n: Int): Int {
        var ones = 0
        var num = n
        while (num != 0) {
            if (num % 2 == 1) ones++
            num /= 2
        }
        return ones
    }
}
