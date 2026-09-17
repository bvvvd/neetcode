class Solution {

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        val openings = setOf('(', '{', '[')
        val closings = mapOf(')' to '(', '}' to '{', ']' to '[')

        for (c in s) {
            if (c in openings) {
                stack.push(c)
            } else if (stack.isEmpty() || stack.pop() != closings[c]) {
                return false
            }
        }

        return stack.isEmpty()
    }
}
