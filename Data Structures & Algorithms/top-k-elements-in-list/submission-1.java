class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num: nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }

        if (frequencies.size() < k) {
            return new int[]{};
        }

        int max = 0;
        for (int key: frequencies.keySet()) {
            max = Math.max(max, frequencies.get(key));
        }

        List<List<Integer>> buckets = new ArrayList<>(max + 1);
        for (int i = 0; i <= max; i++) {
            buckets.add(new ArrayList<>());
        }
        for (var entry: frequencies.entrySet()) {
            int uniqueNumber = entry.getKey();
            int frequency = entry.getValue();
            buckets.get(frequency).add(uniqueNumber);
        }

        int[] topFrequent = new int[k];
        int index = 0;
        for (int i = buckets.size() - 1; i >= 0; i--) {
            for (int uniqueNumber: buckets.get(i)) {
                if (index == k) {
                    return topFrequent;
                }
                topFrequent[index] = uniqueNumber;
                index++;
            }
        }
        return topFrequent;
    }
}
