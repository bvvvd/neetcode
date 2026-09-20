import kotlin.random.Random

class RandomizedSet() {
    private val indices = mutableMapOf<Int, Int>()
    private val values = mutableListOf<Int>()

    fun insert(`val`: Int): Boolean {
        if (indices[`val`] == null) {
            values.add(`val`)
            indices[`val`] = values.size - 1
            return true
        }

        return false
    }

    fun remove(`val`: Int): Boolean {
        if (indices[`val`] != null) {
            val index = indices[`val`]

            val swapValue = values.last()
            values.set(index!!, swapValue)
            indices[swapValue] = index!!
            values.removeLast()
            indices.remove(`val`)
            return true
        }
        return false
    }

    fun getRandom(): Int = values[Random.nextInt(values.size)]
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * val obj = RandomizedSet()
 * val param_1 = obj.insert(`val`)
 * val param_2 = obj.remove(`val`)
 * val param_3 = obj.getRandom()
 */
