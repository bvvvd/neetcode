/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    private Map<Integer, Integer> cache;
    private int length;
    private MountainArray mountainArray;

    public int findInMountainArray(int target, MountainArray mountainArr) {
        length = mountainArr.length();
        cache = new HashMap<>();
        this.mountainArray = mountainArr;

        int peakIndex = findPeak();
        
        int left = search(0, peakIndex, target);
        if (left != -1) {
            return left;
        }

        return reversedSearch(peakIndex + 1, length - 1, target);
    }

    private int findPeak() {
        int left = 0;
        int right = length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (get(mid) < get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private int get(int index) {
        Integer cachedValue = cache.get(index);
        if (cachedValue != null) {
            return cachedValue;
        }
        
        cachedValue = mountainArray.get(index);
        cache.put(index, cachedValue);
        return cachedValue;
    }

    private int search(int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int midValue = get(mid);
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    private int reversedSearch(int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int midValue = get(mid);
            if (midValue == target) {
                return mid;
            } else if (midValue > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}