class MedianFinder {
    private val left = PriorityQueue<Int>(reverseOrder())
    private val right = PriorityQueue<Int>()

    fun addNum(num: Int) {
        left.add(num)
        right.add(left.poll())
        if (right.size > left.size) {
            left.add(right.poll())
        }  
    }

    fun findMedian(): Double {
        return if (left.size == right.size) {
            (left.peek() + right.peek()) / 2.0
        } else {
            if (left.isEmpty()) right.peek().toDouble() else left.peek().toDouble()
        }
    }
}
