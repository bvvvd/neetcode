class FreqStack {
    private Map<Integer, Integer> frequencies;
    private Map<Integer, Stack<Integer>> buckets;
    private int max;

    public FreqStack() {
        frequencies = new HashMap<>();
        buckets = new HashMap<>();
        max = 0;
    }
    
    public void push(int val) {
        int frequency = frequencies.getOrDefault(val, 0) + 1;
        max = Math.max(max, frequency);
        frequencies.put(val, frequency);
        buckets.computeIfAbsent(frequency, value -> new Stack<>()).push(val);
    }
    
    public int pop() {
        Stack<Integer> bucket = buckets.get(max);
        int value = bucket.pop();

        if (bucket.isEmpty()) {
            max--;
        }

        int frequency = frequencies.get(value);
        if (frequency == 1) {
            frequencies.remove(value);
        } else {
            frequencies.put(value, frequency - 1);
        }

        return value;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */