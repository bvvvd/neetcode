class Solution {
    public int rob(int[] nums) {
        int onePre = 0;
        int twoPre = 0;
        for (int num: nums) {
            int next = Math.max(twoPre + num, onePre);
            twoPre = onePre;
            onePre = next;
        }

        return onePre;
    }
}
