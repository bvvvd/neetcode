class MyHashSet {
    private List<List<Integer>> buckets;

    public MyHashSet() {
        buckets = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            buckets.add(new ArrayList<>());
        }
    }
    
    public void add(int key) {
        int index = key % 16;
        
        if (!buckets.get(index).contains(key)) {
            buckets.get(index).add(key);
        }
    }
    
    public void remove(int key) {
        int index = key % 16;

        Iterator<Integer> bucketIterator = buckets.get(index).iterator();
        while (bucketIterator.hasNext()) {
            if (bucketIterator.next() == key) {
                bucketIterator.remove();
            }
        }
    }
    
    public boolean contains(int key) {
        int index = key % 16;

        return buckets.get(index).contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */