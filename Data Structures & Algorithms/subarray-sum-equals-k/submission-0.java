class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumFrequencies = new HashMap<>();
        sumFrequencies.put(0, 1);
        int counter = 0;
        int sum = 0;
        for (int num: nums) {
            sum += num;

            counter += sumFrequencies.getOrDefault(sum - k, 0);
            sumFrequencies.put(sum, sumFrequencies.getOrDefault(sum, 0) + 1);
        }
        return counter;
    }
}