class MyHashSet() {
    data class Node(
        var n: Int? = null,
        val children: Array<Node?> = arrayOfNulls(10)
    )
    private val root = Node()

    fun add(key: Int) {
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
            cursor.children[num] = Node(key)
        }else
            cursor.children[num]?.n = key
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
            cursor.children[num]?.n = null
        }

    }

    fun contains(key: Int): Boolean {
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
            if (cursor.children[num]?.n == key)
                return true
        }
        return false
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */

fun main(){
    var obj = MyHashSet()
    obj.add(0)
    println(obj.contains(0))
    obj.add(1023)
    println("${obj.contains(1023)}, ${obj.contains(1024)}")
    obj.remove(1023)
    obj.remove(1024)
    println("${obj.contains(1023)}, ${obj.contains(1024)}")
    obj.add(1023)
    println("${obj.contains(1023)}, ${obj.contains(1024)}")
}