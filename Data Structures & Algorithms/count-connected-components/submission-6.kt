class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val uf = UnionFind(n)
        edges.forEach {
            uf.union(it[0], it[1])
        }

        return uf.count()
    }

    class UnionFind(n: Int) {
        private val roots = IntArray(n) { it }
        private val ranks = IntArray(n) { 1 }

        fun union(left: Int, right: Int) {
            val leftRoot = find(left)
            val rightRoot = find(right)

            if (leftRoot == rightRoot) return

            when {
                ranks[leftRoot] > ranks[rightRoot] -> roots[rightRoot] = leftRoot
                ranks[leftRoot] < ranks[rightRoot] -> roots[leftRoot] = rightRoot
                else -> {
                    roots[rightRoot] = leftRoot
                    ranks[leftRoot]++
                }
            }
        }

        private fun find(node: Int): Int {
            if (node != roots[node]) {
                roots[node] = find(roots[node])
            }
            return roots[node]
        }

        fun count(): Int {
            var count = 0
            roots.forEachIndexed{ i, root -> if (root == i) count++}
            return count
        }
    }
}
