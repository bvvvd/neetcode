class MyStack {
    private final Queue<Integer> left;
    private final Queue<Integer> right;

    public MyStack() {
        left = new LinkedList<>();
        right = new LinkedList<>();
    }
    
    public void push(int x) {
        if (left.isEmpty()) {
            push(left, right, x);
        } else {
            push(right, left, x);
        }
    }

    private void push(Queue<Integer> leader, Queue<Integer> follower, int value) {
        leader.add(value);
        while (!follower.isEmpty()) {
            leader.add(follower.poll());
        }
    }
    
    public int pop() {
        if (left.isEmpty()) {
            return pop(right);
        } else {
            return pop(left);
        }
    }

    private int pop(Queue<Integer> queue) {
        return queue.poll();
    }
    
    public int top() {
        if (left.isEmpty()) {
            return top(right);
        } else {
            return top(left);
        } 
    }

    private int top(Queue<Integer> queue) {
        return queue.peek();
    }
    
    public boolean empty() {
        return left.isEmpty() && right.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */