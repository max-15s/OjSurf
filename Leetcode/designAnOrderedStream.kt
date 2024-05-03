// 1656 - https://leetcode.com/problems/design-an-ordered-stream/description/
class OrderedStream(n: Int) {
    private val data = Array<String?>(n) { null }
    private var ptr = 0

    fun insert(idKey: Int, value: String): List<String> {
        data[idKey - 1] = value
        val lastPtr = ptr
        for ( i in ptr .. data.size - 1)
            if (data[ptr] != null)
                ptr = i
        return data.slice(lastPtr..ptr).filterNotNull()
    }
}

fun main() {
    val os = OrderedStream(5);
    println( os.insert(3, "ccccc")) // Inserts (3, "ccccc"), returns [].
    println( os.insert(1, "aaaaa")) // Inserts (1, "aaaaa"), returns ["aaaaa"].
    println( os.insert(2, "bbbbb")) // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
    println( os.insert(5, "eeeee")) // Inserts (5, "eeeee"), returns [].
    println( os.insert(4, "ddddd")) // Inserts (4, "ddddd"), returns ["ddddd", "eeeee"].
}