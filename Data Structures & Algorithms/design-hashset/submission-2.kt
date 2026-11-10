class MyHashSet() {
    private val buckets = Array<Node?>(1337) { null }

    fun add(key: Int) {
        val index = hash(key)

        if (buckets[index] == null) {
            buckets[index] = Node(key, null)
        } else {
            var node = buckets[index]
            while (node != null) {
                if (node.value == key) return
                node = node.next
            }
            buckets[index] = Node(key, buckets[index])
        }
    }

    fun remove(key: Int) {
        val index = hash(key)

        var node = buckets[index]
        if (node == null) return
        if (node.value == key) buckets[index] = null
        else {
            var prev: Node? = null
            while (node != null) {
                if (node.value == key) {
                    prev?.next = node.next
                    return
                }
                prev = node
                node = node.next
            }
        }        
    }

    fun contains(key: Int): Boolean {
        var node = buckets[hash(key)]
        while (node != null) {
            if (node.value == key) return true
            node = node.next
        }
        return false
    }

    private fun hash(value: Int): Int = value % buckets.size

    private data class Node(val value: Int, var next: Node?)
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */
