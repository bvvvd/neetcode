class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        var islandCount = 0
        fun traverse(i: Int, j: Int) {
            if (i !in grid.indices || j !in grid[i].indices || grid[i][j] == '0') return

            grid[i][j] = '0'
            traverse(i + 1, j)
            traverse(i - 1, j)
            traverse(i, j + 1)
            traverse(i, j - 1)
        }

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '1') {
                    islandCount++
                    traverse(i, j)
                }
            }
        }

        return islandCount
    }
}
