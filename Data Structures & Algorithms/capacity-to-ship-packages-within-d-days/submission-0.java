class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0;
        int sum = 0;
        for (int weight: weights) {
            if (weight > maxWeight) {
                maxWeight = weight;
            }
            sum += weight;
        }

        int left = maxWeight;
        int right = sum;
        int capacity = sum;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {
                capacity = Math.min(capacity, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return capacity;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int ships = 1;
        int currentCapacity = capacity;

        for (int weight: weights) {
            if (currentCapacity - weight < 0) {
                ships++;
                if (ships > days) {
                    return false;
                }

                currentCapacity = capacity;
            }

            currentCapacity -= weight;
        }

        return true;
    }
}