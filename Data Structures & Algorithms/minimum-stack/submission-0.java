class MinStack {
    private final Stack<StackEntry> stack;
    
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new StackEntry(val, val));
        } else {
            stack.push(new StackEntry(val, Math.min(val, stack.peek().min)));
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

    private record StackEntry(int value, int min) {}
}
