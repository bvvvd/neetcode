class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num: nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> majorityElements = new ArrayList<>();
        for (int key: frequencies.keySet()) {
            if (frequencies.get(key) > nums.length / 3) {
                majorityElements.add(key);
            }
        }

        return majorityElements;
    }
}