class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int pivot = findPivot(arr, x);

        LinkedList<Integer> closestElements = new LinkedList<>();
        int left = pivot - 1;
        int right = pivot;
        System.out.println(pivot);
        while (closestElements.size() < k) {
            if (left < 0) {
                closestElements.add(arr[right]);
                right++;
            } else if (right >= arr.length) {
                closestElements.addFirst(arr[left]);
                left--;
            } else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                closestElements.addFirst(arr[left]);
                left--;
            } else {
                closestElements.add(arr[right]);
                right++;
            }
        }

        return closestElements;
    }

    private int findPivot(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}