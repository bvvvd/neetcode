class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int shortestLength = Integer.MAX_VALUE;
        for (String str: strs) {
            shortestLength = Math.min(shortestLength, str.length());
        }
        int length = 0;
        while (length < shortestLength) {
            char commonChar = strs[0].charAt(length);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(length) != commonChar) {
                    return strs[i].substring(0, length);
                }
            }
            length++;
        }
        
        return strs[0].substring(0, length);
    }
}