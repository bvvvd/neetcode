class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num: nums) {
            heap.add(num);
        }
        while (!heap.isEmpty()) {
            nums[nums.length - heap.size()] = heap.poll(); 
        }
        return nums;
    }
}