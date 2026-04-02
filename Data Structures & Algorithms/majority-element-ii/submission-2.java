class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> counters = new HashMap<>();
        for (int num: nums) {
            counters.put(num, counters.getOrDefault(num, 0) + 1);

            if (counters.size() > 2) {
                for (int key: new ArrayList<>(counters.keySet())) {
                    if (counters.get(key) == 1) {
                        counters.remove(key);
                    } else {
                        counters.put(key, counters.get(key) - 1);
                    }
                }
            }
        }

        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num: nums) {
            if (counters.containsKey(num)) {
                frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
            }
        }

        Iterator<Integer> iterator = frequencies.keySet().iterator();
        while (iterator.hasNext()) {
            if (frequencies.get(iterator.next()) < nums.length / 3 + 1) {
                iterator.remove();
            }
        }
        
        return new ArrayList<>(frequencies.keySet());
    }
}