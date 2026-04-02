class LFUCache {
    private final Map<Integer, Integer> frequencyMap = new HashMap<>();
    private final Map<Integer, LRUList> lruMap = new HashMap<>();
    private final int capacity;
    private int minFrequency;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!frequencyMap.containsKey(key)) {
            return -1;
        }

        int frequency = frequencyMap.get(key);
        Node node = lruMap.get(frequency).remove(key);
        int value = node.value;
        if (!lruMap.containsKey(frequency + 1)) {
            lruMap.put(frequency + 1, new LRUList());
        }
        lruMap.get(frequency + 1).put(key, value);
        if (lruMap.get(minFrequency).isEmpty()) {
            minFrequency++;   
        }
        frequencyMap.put(key, frequency + 1);
        return value;
    }
    
    public void put(int key, int value) {
        if (frequencyMap.size() == capacity && !frequencyMap.containsKey(key)) {
            frequencyMap.remove(lruMap.get(minFrequency).evict().key);
        }

        if (frequencyMap.containsKey(key)) {
            int frequency = frequencyMap.get(key);
            LRUList lru = lruMap.get(frequency);
            lru.remove(key);
            if (lru.isEmpty()) {
                minFrequency++;
            }
            if (!lruMap.containsKey(frequency + 1)) {
                lruMap.put(frequency + 1, new LRUList());
            }
            lruMap.get(frequency + 1).put(key, value);
            frequencyMap.put(key, frequency + 1);
        } else {
            minFrequency = 1;
            if (!lruMap.containsKey(minFrequency)) {
                lruMap.put(minFrequency, new LRUList());
            }
            lruMap.get(minFrequency).put(key, value);
            frequencyMap.put(key, 1);
        }
    }

    private class LRUList {
        private final Map<Integer, Node> map = new HashMap<>();
        private final Node tail;
        private final Node head;

        LRUList() {
            tail = new Node();
            head = new Node();
            tail.right = head;
            head.left = tail;
        }

        boolean isEmpty() {
            return tail.right == head;
        }

        Node remove(int key) {
            Node node = map.get(key);
            node.left.right = node.right;
            node.right.left = node.left;
            map.remove(key);
            return node;
        }

        void put(int key, int value) {
            Node node = new Node();
            node.key = key;
            node.value = value;
            node.left = head.left;
            node.right = head;
            head.left.right = node;
            head.left = node;
            map.put(key, node);
        }

        Node evict() {
            Node node = tail.right;
            node.left.right = node.right;
            node.right.left = node.left;
            return node;
        }
    }

    private class Node {
        private int key;
        private int value;
        private Node left;
        private Node right;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */