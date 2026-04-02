class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int end = s.length() - 1;
        if (s.charAt(end) == '1') {
            return false;
        }

        while (end > 0) {
            int newEnd = end;
            for (int i = end - minJump; i >= 0 && i >= end - maxJump; i--) {
                if (s.charAt(i) == '0') {
                    newEnd = i;
                }
            }

            if (newEnd == end) {
                return false;
            }
            end = newEnd;
        }

        return end <= 0;
    }
}