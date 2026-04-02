class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int maxLength = 1;
        int left = 0;
        int right = 1;
        int previous = ' ';
        while (right < arr.length) {
            if (arr[right - 1] > arr[right] && previous != '>') {
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
                previous = '>';
            } else if (arr[right - 1] < arr[right] && previous != '<') {
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
                previous = '<';
            } else {
                right = (arr[right] == arr[right - 1]) ? right + 1 : right;
                left = right - 1;
                previous = ' ';
            }
        }

        return maxLength;
    }
}