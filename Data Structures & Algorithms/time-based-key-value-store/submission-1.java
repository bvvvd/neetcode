class TimeMap {
    private final Map<String, List<Entry>> storage;

    public TimeMap() {
        storage = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        if (!storage.containsKey(key)) {
            storage.put(key, new ArrayList<>());
        }

        storage.get(key).add(new Entry(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Entry> bucket = storage.getOrDefault(key, List.of());

        return search(bucket, timestamp);
    }

    private String search(List<Entry> bucket, int timestamp) {
        int left = 0;
        int right = bucket.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            Entry candidate = bucket.get(mid);
            if (candidate.timestamp == timestamp) {
                return candidate.value;
            } else if (candidate.timestamp < timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right >= 0 ? bucket.get(right).value : "";
    }

    private record Entry(int timestamp, String value) {}
}
