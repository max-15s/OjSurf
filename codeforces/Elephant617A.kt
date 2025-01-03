fun main() {
    val distance = readln().toInt()
    val k = (distance / 5).toInt()
    val c = distance % 5
    if (c == 0) println(k) else println(k+1)

}