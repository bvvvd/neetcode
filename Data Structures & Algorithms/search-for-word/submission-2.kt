class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        fun backtrack(i: Int, j: Int, index: Int): Boolean {
            if (index > word.lastIndex) {
                return true
            }

            if (!(i in board.indices) || !(j in board[i].indices)) {
                return false
            }
            val c = board[i][j]
            if (c != word[index]) {
                return false
            }

            board[i][j] = '.'
            val result = backtrack(i - 1, j, index + 1)
                || backtrack(i + 1, j, index + 1)
                || backtrack(i, j - 1, index + 1)
                || backtrack(i, j + 1, index + 1)
            board[i][j] = c
            return result
        }

        for (i in board.indices) {
            for (j in board[i].indices) {
                if (backtrack(i, j, 0)) return true
            }
        }

        return false
    }
}
