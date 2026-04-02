class MinStack {
    private Stack<Entry> stack;

    public MinStack() {
        stack = new Stack<>();    
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Entry(val, val));
        } else {
            stack.push(new Entry(val, Math.min(val, stack.peek().min)));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().value;
    }
    
    public int getMin() {
        return stack.peek().min;
    }

    private record Entry(int value, int min) {

    }
}
