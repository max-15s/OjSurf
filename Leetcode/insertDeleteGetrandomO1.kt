// https://leetcode.com/problems/insert-delete-getrandom-o1/

class RandomizedSet() {
    val memory = HashMap<Int, Boolean>()

    fun insert(`val`: Int): Boolean {
        val present = memory[`val`]
        memory[`val`] = false
        return present == null
    }

    fun remove(`val`: Int): Boolean {
        val present = memory[`val`]
        if (present != null) memory.remove(`val`)
        return present != null
    }

    fun getRandom(): Int {
        return memory.keys.random()
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */