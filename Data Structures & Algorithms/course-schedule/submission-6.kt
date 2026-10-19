class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val dependents = Array(numCourses) { mutableListOf<Int>() }
        val inDegree = IntArray(numCourses)
        for ((course, prerequisite) in prerequisites) {
            dependents[prerequisite].add(course)
            inDegree[course]++
        }

        val queue = ArrayDeque(inDegree.indices.filter { inDegree[it] == 0 })
        var taken = 0
        while (queue.isNotEmpty()) {
            val course = queue.removeFirst()
            taken++
            for (next in dependents[course]) {
                inDegree[next]--
                if (inDegree[next] == 0) queue.addLast(next)
            }
        }
        return taken == numCourses
    }
}