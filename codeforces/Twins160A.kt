// https://codeforces.com/problemset/problem/160/A
fun main() {
    val dummy = readLine()!!.toInt()
    val conis: List<Int> = readln().trim().split(" ").map { it.toInt() }
    val sortedCoins = conis.sortedDescending()
    val minToPick = conis.sum() / 2.0
    var total = 0
    var cnt = 0
    for (i in sortedCoins.indices) {
        if (total > minToPick) {
            break
        }
        total += sortedCoins[i]
        cnt += 1
    }
    println(cnt)
}