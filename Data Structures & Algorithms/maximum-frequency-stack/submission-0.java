class FreqStack {
    private Map<Integer, Integer> frequencies;
    private LinkedList<Integer> values;

    public FreqStack() {
        frequencies = new HashMap<>();
        values = new LinkedList<>();
    }
    
    public void push(int val) {
        frequencies.put(val, frequencies.getOrDefault(val, 0) + 1);
        values.addFirst(val);
    }
    
    public int pop() {
        int max = 0;
        for (int i: frequencies.values()) {
            if (max < i) {
                max = i;
            }
        }
        Set<Integer> mostFrequent = new HashSet<>();
        for (var entry: frequencies.entrySet()) {
            if (entry.getValue() == max) {
                mostFrequent.add(entry.getKey());
            }
        }

        Iterator<Integer> iterator = values.iterator();
        while (iterator.hasNext()) {
            int value = iterator.next();

            if (mostFrequent.contains(value)) {
                iterator.remove();
                
                if (max == 1) {
                    frequencies.remove(value);
                } else {
                    frequencies.put(value, max - 1);
                }
                return value;
            }
        }

        return -1;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */