class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num: nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);

            if (frequencies.size() > 2) {
                for (int key: new ArrayList<>(frequencies.keySet())) {
                    int frequency = frequencies.get(key);
                    if (frequency == 1) {
                        frequencies.remove(key);
                    } else {
                        frequencies.put(key, frequency - 1);
                    }
                }
            }
        }

        for (int key: new ArrayList<>(frequencies.keySet())) {
            frequencies.put(key, 0);
        }

        List<Integer> majorityElements = new ArrayList<>(2);
        for (int num: nums) {
            int frequency = frequencies.getOrDefault(num, -1);
            if (frequency >= 0) {
                frequencies.put(num, frequency + 1);
            }
        }
        for (int key: frequencies.keySet()) {
            if (frequencies.get(key) > nums.length / 3) {
                majorityElements.add(key);
            }
        }

        return majorityElements;
    }
}