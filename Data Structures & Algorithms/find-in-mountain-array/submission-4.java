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
    private MountainArray array;
    private int target;
    private int length;

    public int findInMountainArray(int target, MountainArray mountainArr) {
        cache = new HashMap<>();
        array = mountainArr;
        this.target = target;
        length = array.length();

        int peak = findPeak();
        if (target >= get(0) && target <= get(peak - 1)) {
            int foundIndex = find(0, peak - 1);

            if (foundIndex >= 0) {
                return foundIndex;
            }
        }

        return findReverse(peak, length - 1);
    }

    private int findPeak() {
        int left = 0;
        int right = length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (get(mid + 1) > get(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int find(int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (get(mid) == target) {
                return mid;
            } else if (get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    private int findReverse(int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (get(mid) == target) {
                return mid;
            } else if (get(mid) < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    private int get(int index) {
        if (!cache.containsKey(index)) {
            cache.put(index, array.get(index));
        }

        return cache.get(index);
    }
}