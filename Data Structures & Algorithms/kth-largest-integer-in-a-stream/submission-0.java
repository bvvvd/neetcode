class KthLargest {
    private final PriorityQueue<Integer> stream;
    private final int capacity;

    public KthLargest(int k, int[] nums) {
        stream = new PriorityQueue<>();
        capacity = k;

        for (int num: nums) {
            if (stream.size() < capacity) {
                stream.add(num);
            } else if (stream.peek() < num) {
                stream.poll();
                stream.add(num);
            }
        }
    }
    
    public int add(int val) {
        if (stream.size() < capacity) {
            stream.add(val);
        } else if (stream.peek() < val) {
            stream.poll();
            stream.add(val);
        }
        return stream.peek();
    }
}
