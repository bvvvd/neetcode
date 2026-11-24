class Solution {
    fun rotate(matrix: Array<IntArray>) {
        for (i in matrix.indices) {
            for (j in 0..i) {
                val swap = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = swap
            }
        }
        for (i in matrix.indices) {
            for (j in 0 until matrix.size / 2) {
                val swap = matrix[i][j]
                matrix[i][j] = matrix[i][matrix.size - j - 1]
                matrix[i][matrix.size - j - 1] = swap
            }
        }
    }
}
