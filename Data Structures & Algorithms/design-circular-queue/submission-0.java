class MyCircularQueue {
    private final int[] data;
    private int size;
    private int tail;
    private int head;

    public MyCircularQueue(int k) {
        data = new int[k];
        size = 0;
        tail = 0;
        head = 0;
    }
    
    public boolean enQueue(int value) {
        if (size == data.length) {
            return false;
        }

        data[head] = value;
        head = (head + 1) % data.length;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (size == 0) {
            return false;
        }

        tail = (tail + 1) % data.length;
        size--;
        return true;
    }
    
    public int Front() {
        return size == 0 ? -1 : data[tail];
    }
    
    public int Rear() {
        return size == 0 ? -1 : data[(head - 1 + data.length) % data.length];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == data.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */