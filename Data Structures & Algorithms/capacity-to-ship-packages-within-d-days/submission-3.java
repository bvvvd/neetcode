class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 1;
        int right = 1;
        for (int weight: weights) {
            if (left < weight) {
                left = weight;
            }
            right += weight;
        }

        int minCapacity = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {
                minCapacity = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return minCapacity;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int shipNeeded = 1;
        int currentCapacity = capacity;
        for (int weight: weights) {
            if (weight > capacity) {
                return false;
            }

            if (weight > currentCapacity) {
                shipNeeded++;
                currentCapacity = capacity;
            }
            currentCapacity -= weight;

            if (shipNeeded > days) {
                return false;
            }
        }

        return true;
    }
}