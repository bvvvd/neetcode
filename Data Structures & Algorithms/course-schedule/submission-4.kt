class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val dependencies = Array(numCourses) { mutableSetOf<Int>() }
        val inDegree = IntArray(numCourses)
        for ((destination, source) in prerequisites) {
            inDegree[destination]++

            dependencies[source].add(destination)
        }

        var coursesTaken = 0
        val courses = ArrayDeque<Int>()
        inDegree.forEachIndexed { i, degree -> 
            if (degree == 0) {
                coursesTaken++
                courses.add(i)
            }
        }

        while (courses.isNotEmpty()) {
            val course = courses.poll()
    
            val dependentCourses = dependencies[course]
            for (dependant in dependentCourses) {
                inDegree[dependant]--
                if (inDegree[dependant] == 0) {
                    courses.add(dependant)
                    coursesTaken++
                }
            }
        }

        return coursesTaken == numCourses
    }
}
