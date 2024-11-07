// 2120 - https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid/description/

class Solution {

    fun isInsideGrid(position: Pair<Int, Int>, boxSize: Int): Boolean {
        if (position.first < 0 || position.first >= boxSize) return false
        if (position.second < 0 || position.second >= boxSize) return false
        return true
    }

    fun u(position: Pair<Int, Int>): Pair<Int, Int> {
        return position.first - 1 to position.second
    }

    fun d(position: Pair<Int, Int>): Pair<Int, Int> {
        return position.first + 1 to position.second
    }

    fun r(position: Pair<Int, Int>): Pair<Int, Int> {
        return position.first to position.second + 1
    }

    fun l(position: Pair<Int, Int>): Pair<Int, Int> {
        return position.first to position.second - 1
    }

    fun executeInstructions(n: Int, startPos: IntArray, s: String): IntArray {
        val result = IntArray(s.length) { 0 }
        for (i in s.indices) {
            var currentPos = startPos[0] to startPos[1]
            for (j in i..<s.length) {
                val nextPos = when (s[j]) {
                    'U' -> u(currentPos)
                    'D' -> d(currentPos)
                    'L' -> l(currentPos)
                    'R' -> r(currentPos)
                    else -> -1 to -1
                }
                if (isInsideGrid(nextPos, n)) {
                    currentPos = nextPos
                    result[i] += 1
                } else break
            }
        }
        return result
    }
}

fun main() {
    val s = Solution()
    println( s.executeInstructions(3, intArrayOf(0,1), "RRDDLU").joinToString(", "))
}
