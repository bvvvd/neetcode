class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length < 0 || k < 1) {
            return new int[]{};
        }

        Map<Integer, Integer> numberFrequencies = new HashMap<>();
        for (int num: nums) {
            numberFrequencies.put(num, numberFrequencies.getOrDefault(num, 0) + 1);
        }

        if (numberFrequencies.size() < k) {
            return new int[]{};
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int uniqueNumber: numberFrequencies.keySet()) {
            int frequency = numberFrequencies.get(uniqueNumber);

            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(uniqueNumber);
        }

        int[] topFrequent = new int[k];
        int index = 0;
        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int number: buckets[i]) {
                    if (index == k) {
                        break;
                    } else {
                        topFrequent[index] = number;
                        index++;
                    }
                }
            }
        }

        return topFrequent;
    }
}
