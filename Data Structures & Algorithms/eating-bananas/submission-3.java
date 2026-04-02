class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile: piles) {
            if (pile > right) {
                right = pile;
            }
        }
        int minSpeed = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canEat(piles, mid, h)) {
                minSpeed = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return minSpeed;
    }

    private boolean canEat(int[] piles, int speed, int hours) {
        int hoursNeeded = 0;
        for (int pile: piles) {
            hoursNeeded += pile / speed;
            if (pile % speed != 0) {
                hoursNeeded++;
            }

            if (hoursNeeded > hours) {
                return false;
            }
        }

        return true;
    }
}
