class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val grid = Array(m) { IntArray(n) }
        for (i in 0 until m) {
            grid[i][0] = 1
        }
        for (i in 0 until n) {
            grid[0][i] = 1
        }
        for (i in 1 until m) {
            for (j in 1 until n) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1]
            }
        }
        
        return grid[m - 1][n - 1]
    }
}
