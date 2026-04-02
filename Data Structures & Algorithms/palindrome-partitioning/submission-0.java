class Solution {
    private List<List<String>> partitions;
    private String s;
    public List<List<String>> partition(String s) {
        this.s = s;
        partitions = new ArrayList<>();
        backtrack(0, new LinkedList<>());
        return partitions;
    }

    private void backtrack(int start, LinkedList<String> partition) { // 0 []
        if (start >= s.length()) {                                    //
            partitions.add(new ArrayList<>(partition));               //
        } else {                                                      //
            for (int i = start; i < s.length(); i++) {                //
                if (isPalindrome(start, i)) {                         //
                    String substring = s.substring(start, i + 1);     //
                    partition.add(substring);                         //
                    backtrack(i + 1, partition);                      //
                    partition.removeLast();                           //
                }
            }
        }
    }

    private boolean isPalindrome(int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
