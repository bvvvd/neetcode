class Solution {
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val graph = mutableMapOf<String, MutableList<Pair<String, Double>>>()
        for (i in equations.indices) {
            val (a,b) = equations[i]
            
            graph.getOrPut(a) { mutableListOf() }.add(b to values[i])
            graph.getOrPut(b) { mutableListOf() }.add(a to 1 / values[i])
        }

        fun calculate(start: String, end: String): Double {
            if (start !in graph || end !in graph) return -1.0

            val queue = ArrayDeque<Pair<String, Double>>()
            queue.add(start to 1.0)
            val seen = mutableSetOf<String>(start)

            while (queue.isNotEmpty()) {
                val (node,accumulator) = queue.poll()

                if (node == end) return accumulator

                graph[node]?.forEach { (neighbor,multiplier) ->
                    if (seen.add(neighbor)) queue.add(neighbor to accumulator * multiplier)
                }
            }

            return -1.0
        }

        return queries.map { calculate(it[0], it[1]) }.toDoubleArray()
    }
}
