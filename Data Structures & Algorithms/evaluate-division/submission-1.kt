class Solution {
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val graph = mutableMapOf<String, MutableList<Pair<String, Double>>>()
        for (i in equations.indices) {
            graph.getOrPut(equations[i][0]) { mutableListOf() }.add(equations[i][1] to values[i])
            graph.getOrPut(equations[i][1]) { mutableListOf() }.add(equations[i][0] to 1 / values[i])
        }

        fun calculate(start: String, destination: String): Double {
            if (!graph.containsKey(destination) || !graph.containsKey(start)) return -1.0
            val queue = ArrayDeque<Pair<String, Double>>()
            queue.add(start to 1.0)
            val seen = mutableSetOf<String>()

            while (queue.isNotEmpty()) {
                val (node, value) = queue.poll()

                if (node == destination) return value

                graph[node]?.forEach { ( neighbor, multiplier ) ->
                    if (!seen.contains(neighbor)) {
                        seen.add(neighbor)
                        queue.add(neighbor to value * multiplier)
                    }
                }
            }

            return -1.0
        }

        return queries.map { calculate(it[0], it[1]) }.toDoubleArray()
    }
}
