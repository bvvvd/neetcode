class LRUCache {
    private final Map<Integer, Node> map = new HashMap<>();
    private final int capacity;
    private final Node tail;
    private final Node head;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail = new Node();
        head = new Node();
        tail.right = head;
        head.left = tail;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        int value = node.value;
        moveToHead(node);
        return value;
    }
    
    public void put(int key, int value) {
        if (map.size() == capacity && !map.containsKey(key)) {
            evict();
        }
        Node node = map.getOrDefault(key, new Node());
        node.key = key;
        node.value = value;
        moveToHead(node);
        map.put(key, node);
    }

    private void moveToHead(Node node) {
        if (node.left != null) {
            node.left.right = node.right;
        }
        if (node.right != null) {
            node.right.left = node.left;
        }
        node.left = head.left;
        node.left.right = node;
        node.right = head;
        head.left = node;
    }

    private void evict() {
        Node node = tail.right;
        map.remove(node.key);
        node.left.right = node.right;
        node.right.left = node.left;
    }

    private class Node {
        private int key;
        private int value;
        private Node left;
        private Node right;
    }
}
