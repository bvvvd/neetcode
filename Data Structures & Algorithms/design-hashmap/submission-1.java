class MyHashMap {

    private List<List<Entry>> buckets;

    public MyHashMap() {
        buckets = new ArrayList<>(1024);
        for (int i = 0; i < 1024; i++) {
            buckets.add(new ArrayList<>());
        }
    }
    
    public void put(int key, int value) {
        List<Entry> bucket = getBucket(key);

        for (Entry entry: bucket) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        bucket.add(new Entry(key, value));
    }
    
    public int get(int key) {
        List<Entry> bucket = getBucket(key);

        for (Entry entry: bucket) {
            if (entry.key == key) {
                return entry.value;
            }
        }

        return -1;
    }
    
    public void remove(int key) {
        Iterator<Entry> bucketIterator = getBucket(key).iterator();
        while (bucketIterator.hasNext()) {
            if (bucketIterator.next().key == key) {
                bucketIterator.remove();
            }
        }
    }

    private List<Entry> getBucket(int key) {
        return buckets.get(key % buckets.size());
    }

    private class Entry {
        int key;
        int value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */