class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> = 
        strs.groupBy { it.toCharArray().apply { sort() }.concatToString() }.values.toList()
}
