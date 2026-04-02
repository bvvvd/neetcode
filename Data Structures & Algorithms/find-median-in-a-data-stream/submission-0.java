class MedianFinder {
    private final PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
    private final PriorityQueue<Integer> right = new PriorityQueue<>();
    
    public void addNum(int num) {
        left.add(num);
        while (!right.isEmpty() && right.peek() < left.peek()) {
            left.add(right.poll());
        }
        while (left.size() > right.size()) {
            right.add(left.poll());
        }
    }
    
    public double findMedian() {
        if (left.size() == right.size()) {
            return (double) (left.peek() + right.peek()) / 2;
        } else {
            System.out.println(left);
            System.out.println(right);
            return (double) right.peek();
        }
    }
}
