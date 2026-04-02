class FreqStack {
    private Map<Integer, Integer> frequencies;
    private Map<Integer, Stack<Integer>> groups;
    private int max;

    public FreqStack() {
        frequencies = new HashMap<>();
        groups = new HashMap<>();
        max = 0;
    }
    
    public void push(int val) {
        int frequency = frequencies.getOrDefault(val, 0) + 1;
        frequencies.put(val, frequency);

        if (!groups.containsKey(frequency)) {
            groups.put(frequency, new Stack<>());
        }
        groups.get(frequency).push(val);

        if (max < frequency) {
            max++;
        }
    }
    
    public int pop() {
        if (max < 1) {
            return -1;
        }

        int poppedValue = groups.get(max).pop();
        
        if (max == 1) {
            frequencies.remove(poppedValue);
        } else {
            frequencies.put(poppedValue, max - 1);
        }

        if (groups.get(max).isEmpty()) {
            max--;
        }

        return poppedValue;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */