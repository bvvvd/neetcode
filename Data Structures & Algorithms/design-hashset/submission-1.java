class MyHashSet {
    private List<List<Integer>> buckets;

    public MyHashSet() {
        buckets = new ArrayList<>(1024);
        for (int i = 0; i < 1024; i++) {
            buckets.add(new ArrayList<>());
        }
    }
    
    public void add(int key) {
        int index = getBucketIndex(key);

        if (!contains(key)) {
            buckets.get(index).add(key);
        }
    }
    
    public void remove(int key) {
        int index = getBucketIndex(key);
        
        Iterator<Integer> iterator = buckets.get(index).iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == key) {
                iterator.remove();
                return;
            }
        }
    }
    
    public boolean contains(int key) {
        int index = getBucketIndex(key);

        return buckets.get(index).contains(key);
    }

    private int getBucketIndex(int key) {
        return key % buckets.size();
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */