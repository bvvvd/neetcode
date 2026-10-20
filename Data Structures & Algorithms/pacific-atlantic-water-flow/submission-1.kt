class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        fun traverse(i: Int, j: Int, map: Array<BooleanArray>, height: Int) {
            if (i !in heights.indices || j !in heights[i].indices) return
            if (map[i][j] || heights[i][j] < height) return
            map[i][j] = true
            val cellHeight = heights[i][j]
            traverse(i - 1, j, map, cellHeight)
            traverse(i + 1, j, map, cellHeight)
            traverse(i, j - 1, map, cellHeight)
            traverse(i, j + 1, map, cellHeight)
        }

        val m = heights.size
        val n = heights[0].size
        val pacific = Array(m) { BooleanArray(n) }
        heights.indices.forEach { traverse(it, 0, pacific, 0) }
        heights[0].indices.forEach { traverse(0, it, pacific, 0) }
        val atlantic = Array(m) { BooleanArray(n) }
        heights.indices.forEach { traverse(it, n - 1, atlantic, 0) }
        heights[0].indices.forEach { traverse(m - 1, it, atlantic, 0) }

        val commonCells = mutableListOf<List<Int>>()
        for (i in heights.indices) {
            for (j in heights[i].indices) {
                if (pacific[i][j] && atlantic[i][j]) commonCells.add(listOf(i, j))
            }
        }

        return commonCells
    }
}
