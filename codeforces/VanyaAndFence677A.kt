// https://codeforces.com/problemset/problem/677/A

fun main() {
    val problemDef = readln().trim().split(" ").map { it.toInt() }
    val heights = readln().trim().split(" ").map { it.toInt() }
    val tallOnes = heights.count { it > problemDef[1] }
    println(problemDef[0] + tallOnes)
}