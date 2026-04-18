class Solution {
    public String longestPalindrome(String s) {
        String maxSegment = "";

        for (int i = 0; i < s.length(); i++) {
            String palindrome = growPalindrome(s, i);

            if (palindrome.length() > maxSegment.length()) {
                maxSegment = palindrome;
            }
        }

        return maxSegment;
    }

    private String growPalindrome(String s, int pivot) {
        int oddLeft = pivot;
        int oddRight = pivot;

        while (oddLeft - 1 >= 0 && oddRight + 1 < s.length() && s.charAt(oddLeft - 1) == s.charAt(oddRight + 1)) {
            oddLeft--;
            oddRight++;
        }
        
        int evenLeft = pivot;
        int evenRight = pivot + 1;

        if (evenRight >= s.length() || s.charAt(evenLeft) != s.charAt(evenRight)) {
            return s.substring(oddLeft, oddRight + 1);
        }

        while (evenLeft - 1 >= 0 && evenRight + 1 < s.length() && s.charAt(evenLeft - 1) == s.charAt(evenRight + 1)) {
            evenLeft--;
            evenRight++;
        }

        if (oddRight - oddLeft + 1 > evenRight - evenLeft + 1) {
            return s.substring(oddLeft, oddRight + 1);
        } else {
            return s.substring(evenLeft, evenRight + 1);
        }
    }
}
