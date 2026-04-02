class LFUCache {
    private final Map<Integer, Integer> keyToFrequency = new HashMap<>();
    private final Map<Integer, Integer> valueMap = new HashMap<>();
    private final Map<Integer, LRUList> frequencyToList = new HashMap<>();
    private final int capacity;
    private int minFrequency;

    public LFUCache(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException();
        }

        this.capacity = capacity;
        minFrequency = 1;
    }
    
    public int get(int key) {
        Integer value = valueMap.get(key);
        if (value == null) {
            return -1;
        }

        counter(key);
        return value;
    }
    
    public void put(int key, int value) {
        if (!valueMap.containsKey(key) && valueMap.size() == capacity) {
            int toRemove = frequencyToList.get(minFrequency).popLeft();
            valueMap.remove(toRemove);
            keyToFrequency.remove(toRemove);
        }

        valueMap.put(key, value);
        keyToFrequency.put(key, keyToFrequency.getOrDefault(key, 0));
        counter(key);
        minFrequency = Math.min(minFrequency, keyToFrequency.get(key));
    }

    private void counter(int key) {
        int frequency = keyToFrequency.get(key);
        keyToFrequency.put(key, frequency + 1);
        frequencyToList.putIfAbsent(frequency, new LRUList());
        frequencyToList.get(frequency).pop(key);
        frequencyToList.computeIfAbsent(frequency + 1, v -> new LRUList()).pushRight(key);

        if (frequency == minFrequency && frequencyToList.get(frequency).size() == 0) {
            minFrequency++;
        }
    }

    private static class LRUList {
        private final Map<Integer, Node> map;
        private final Node tail;
        private final Node head;

        LRUList() {
            map = new HashMap<>();
            tail = new Node(0);
            head = new Node(0);
            tail.right = head;
            head.left = tail;
        }

        int size() {
            return map.size();
        }

        void pushRight(int value) {
            Node node = new Node(value);
            node.right = head;
            node.left = head.left;
            head.left.right = node;
            head.left = node;
            map.put(value, node);
        }

        void pop(int value) {
            Node node = map.get(value);
            if (node != null) {
                node.left.right = node.right;
                node.right.left = node.left;
                map.remove(value);
            }
        }

        int popLeft() {
            int value = tail.right.value;
            pop(value);
            return value;
        }

        void update(int value) {
            pop(value);
            pushRight(value);
        }
    }

    private static class Node {
        private Node left;
        private Node right;
        private int value;

        Node(int value) {
            this.value = value;
        }
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */