class Solution {

    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        val openings = setOf('(', '{', '[')
        val closings = mapOf(')' to '(', '}' to '{', ']' to '[')

        for (c in s) {
            if (c in openings) {
                stack.addLast(c)
            } else if (stack.isEmpty() || stack.removeLast() != closings[c]) {
                return false
            }
        }

        return stack.isEmpty()
    }
}
