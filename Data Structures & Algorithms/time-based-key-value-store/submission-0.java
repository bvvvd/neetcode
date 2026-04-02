class TimeMap {

    private final Map<String, List<Entry>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        List<Entry> entries = map.get(key);
        entries.add(new Entry(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Entry> entries = map.get(key);

        int left = 0;
        int right = entries.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            Entry midEntry = entries.get(mid);
            if (midEntry.timestamp == timestamp) {
                return midEntry.value;
            } else if (midEntry.timestamp < timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right >= 0 && right < entries.size()) {
            if (entries.get(right).timestamp <= timestamp) {
                return entries.get(right).value;
            } else {
                return ""; 
            }
        } else {
            return "";
        }
    }

    private record Entry(int timestamp, String value) {}
}
