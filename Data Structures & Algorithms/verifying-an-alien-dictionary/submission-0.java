class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] precedence = new int[26];
        for (int i = 0; i < order.length(); i++) {
            precedence[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            String left = words[i - 1];
            String right = words[i];

            boolean decided = false;
            for (int j = 0; j < left.length() && j < right.length(); j++) {
                int comparison = Integer.compare(precedence[left.charAt(j) - 'a'], precedence[right.charAt(j) - 'a']);
                if (comparison < 0) {
                    decided = true;
                    break;
                } else if (comparison > 0) {
                    return false;
                }
            }

            if (!decided && left.length() > right.length()) {
                return false;
            }
        }

        return true;
    }
}