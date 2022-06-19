class MyHashMap() {
    data class Node(
        var n: Int? = -1,
        val children: Array<Node?> = arrayOfNulls(10)
    )
    private val root = Node()
    fun put(key: Int, value: Int) {
        var cursor = this.root
        var num = key
        while (num / 10 > 0){
            val rem = num % 10
            num /= 10
            if (cursor.children[rem] == null)
                cursor.children[rem] = Node()
            cursor = cursor.children[rem]!!
        }

        if (cursor.children[num] == null){
            cursor.children[num] = Node(value)
        }else
            cursor.children[num]?.n = value
    }

    fun get(key: Int): Int? {
        var cursor = this.root
        var num = key
        while (num / 10 > 0){
            val rem = num % 10
            num /= 10
            if (cursor.children[rem] == null)
                cursor.children[rem] = Node()
            cursor = cursor.children[rem]!!
        }

        if (cursor.children[num] != null){
            return cursor.children[num]?.n
        }
        else
            return -1
    }

    fun remove(key: Int) {
        var cursor = this.root
        var num = key
        while (num / 10 > 0){
            val rem = num % 10
            num /= 10
            if (cursor.children[rem] == null)
                cursor.children[rem] = Node()
            cursor = cursor.children[rem]!!
        }

        if (cursor.children[num] != null){
            cursor.children[num]?.n = -1
        }
    }
}
