class MyStack {
    private Queue<Integer> in;
    private Queue<Integer> out;

    public MyStack() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }
    
    public void push(int x) {
        in.add(x);

        while (!out.isEmpty()) {
            in.add(out.poll());
        }

        Queue<Integer> swap = out;
        out = in;
        in = swap;
    }
    
    public int pop() {
        return out.poll();
    }
    
    public int top() {
        return out.peek();
    }
    
    public boolean empty() {
        return out.isEmpty();
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