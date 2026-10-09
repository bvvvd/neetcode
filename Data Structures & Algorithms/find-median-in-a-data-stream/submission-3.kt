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
            (left.peek().toDouble() + right.peek().toDouble()) / 2.0
        } else {
            left.peek().toDouble()
        }
    }
}
