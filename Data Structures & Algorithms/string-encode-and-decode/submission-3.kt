class Solution {

    fun encode(strs: List<String>): String {
        val builder = StringBuilder()
        strs.forEach {
            builder.append(it.length)
                    .append('#')
                    .append(it)
        }
        return builder.toString()
    }

    fun decode(str: String): List<String> {
        val strs = mutableListOf<String>()
        var i = 0
        while (i < str.length) {
            var length: Int = 0
            while (str[i] != '#') {
                length = length * 10 + (str[i] - '0')
                i++
            }
            i++
            strs.add(str.substring(i, i + length))
            i += length 
        }
        return strs
    }
}
