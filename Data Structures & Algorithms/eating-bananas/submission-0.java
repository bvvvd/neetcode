class Solution {

    // [1, 4, 3, 2], h == 9
    public int minEatingSpeed(int[] piles, int h) {
        int right = 0;
        for (int pile: piles) {
            if (pile > right) {
                right = pile;
            }
        }

        int left = 1;
        int speed = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            int totalTime = 0;
            for (int pile: piles) {
                totalTime += Math.ceil((double) pile / mid);
            }
            if (totalTime <= h) {
                speed = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return speed;
    }
}
