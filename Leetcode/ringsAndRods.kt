// 2103 - https://leetcode.com/problems/rings-and-rods/description/
class Solution {
    fun countPoints(rings: String): Int {
        var points = IntArray(10) { 0 }
        for (i in rings.indices step  2 ) {
            val color = rings[i]
            val index = rings[i+1].digitToInt()
            points[index] = when (color) {
                'R' -> points[index] or 1
                'G' -> points[index] or 2
                'B' -> points[index] or 4
                else -> { points[index] }
            }
        }
        return points.count { it == 7 }
    }
}

fun main() {
    val solution = Solution()
    println( solution.countPoints("B0B6G0R6R0R6G9"))
}