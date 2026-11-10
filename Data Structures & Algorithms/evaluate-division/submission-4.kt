class Solution {
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val graph = mutableMapOf<String, MutableList<Pair<String, Double>>>()
        for (i in equations.indices) {
            val (left, right) = equations[i]
            graph.getOrPut(left) { mutableListOf() }.add(right to values[i])
            graph.getOrPut(right) { mutableListOf() }.add(left to 1 / values[i])
        }

        fun calculate(start: String, destination: String): Double {
            if (start !in graph || destination !in graph) return -1.0
            val queue = ArrayDeque<Pair<String, Double>>()
            queue.add(start to 1.0)
            val seen = mutableSetOf(start)

            while (queue.isNotEmpty()) {
                val (node, value) = queue.poll()

                if (node == destination) return value

                graph[node]?.forEach { ( neighbor,multiplier ) ->
                    if (seen.add(neighbor)) queue.add(neighbor to value * multiplier)
                }
            }

            return -1.0
        }

        return queries.map { calculate(it[0], it[1]) }.toDoubleArray()
    }
}
