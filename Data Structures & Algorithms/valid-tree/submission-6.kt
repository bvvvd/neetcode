class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        if (n - 1 != edges.size) return false

        val uf = UnionFind(n)
        for ((left, right) in edges) {
            if (!uf.union(left, right)) return false
        }

        return true
    }

    class UnionFind(n: Int) {
        private val roots = IntArray(n) { it }
        private val rank = IntArray(n) { 1 }

        fun union(left: Int, right: Int): Boolean {
            val leftRoot = find(left)
            val rightRoot = find(right)

            if (leftRoot == rightRoot) return false

            when {
                rank[leftRoot] > rank[leftRoot] -> roots[rightRoot] = leftRoot
                rank[leftRoot] < rank[rightRoot] -> roots[leftRoot] = rightRoot
                else -> {
                    roots[leftRoot] = rightRoot
                    rank[rightRoot]++
                }
            }

            return true
        }

        fun find(node: Int): Int {
            if (node != roots[node]) {
                roots[node] = find(roots[node])
            }
            return roots[node]
        }
    }
}
