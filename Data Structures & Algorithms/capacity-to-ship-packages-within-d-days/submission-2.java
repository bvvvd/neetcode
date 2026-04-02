class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int weight: weights) {
            right += weight;
            if (weight > left) {
                left = weight;
            }
        }

        int minCapacity = right;
        while (left <= right) {
            int capacity = left + (right - left) / 2;

            if (canShip(weights, days, capacity)) {
                minCapacity = capacity;
                right = capacity - 1;
            } else {
                left = capacity + 1;
            }
        }

        return minCapacity;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int remainingShipCapacity = capacity;
        int shipsNeeded = 1;
        for (int weight: weights) {
            if (weight > remainingShipCapacity) {
                shipsNeeded++;
                remainingShipCapacity = capacity;
            }
            if (shipsNeeded > days) {
                return false;
            }
            remainingShipCapacity -= weight;
        }

        return true;
    }
}