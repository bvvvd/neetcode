class MyHashMap {
    private static final int NUMBER_OF_BUCKETS = 100000;
    private final List<LinkedList<Entry>> buckets;

    public MyHashMap() {
        buckets = new ArrayList<>(NUMBER_OF_BUCKETS);
        for (int i = 0; i < NUMBER_OF_BUCKETS; i++) {
            buckets.add(new LinkedList<>());
        }
    }
    
    public void put(int key, int value) {
        int index = key % NUMBER_OF_BUCKETS;

        LinkedList<Entry> bucket = buckets.get(index);
        for (Entry entry: bucket) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        bucket.add(new Entry(key, value));
    }
    
    public int get(int key) {
        int index = key % NUMBER_OF_BUCKETS;

        LinkedList<Entry> bucket = buckets.get(index);
        for (Entry entry: bucket) {
            if (entry.key == key) {
                return entry.value;
            }
        }

        return -1;
    }
    
    public void remove(int key) {
        
        int index = key % NUMBER_OF_BUCKETS;

        Iterator<Entry> bucketIterator = buckets.get(index).iterator();

        while (bucketIterator.hasNext()) {
            if (bucketIterator.next().key == key) {
                bucketIterator.remove();
                return;
            }
        }
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