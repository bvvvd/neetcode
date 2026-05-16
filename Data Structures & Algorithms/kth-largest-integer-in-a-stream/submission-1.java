class KthLargest {
    private final PriorityQueue<Integer> heap;
    private final int k;

    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>();
        this.k = k;

        for (int num: nums) {
            if (heap.size() < k) {
                heap.add(num);
            } else if (heap.peek() < num) {
                heap.poll();
                heap.add(num);
            }
        }
    }
    
    public int add(int val) {
        if (heap.size() < k) {
            heap.add(val);
        } else if (heap.peek() < val) {
            heap.poll();
            heap.add(val);
        }

        return heap.peek();
    }
}
