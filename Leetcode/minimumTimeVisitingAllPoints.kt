import kotlin.math.abs

// 1266 https://leetcode.com/problems/minimum-time-visiting-all-points/description/
class Solution {
    fun getDiff(x1: Int, y1: Int, x2: Int, y2: Int) : Int {
//        if (x1 == x2) return abs( y2 - y1 )
//        if (y1 == y2) return abs(x2 - x1)
//        if (x2 - x1 == y2 - y1) return abs( x2 - x1)
//
//        val reY2 = x2 - x1 + y1
//        return getDiff(x1, y1, x2, reY2) + getDiff(x2, reY2, x2, y2)

        return maxOf(
            abs(x2-x1),
            abs(y2-y1)
        )
    }

    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        var totalTime = 0
        for ( i in 1 until points.size) {
            totalTime += getDiff(points[i-1][0], points[i-1][1], points[i][0], points[i][1])
        }
        return totalTime
    }
}

fun main() {
    val s = Solution()
    // [1,1],[3,4],[-1,0]
    println(s.getDiff(1,1,3,4))
    println(s.getDiff(3,4,-1,0))

    println("********")
    // [[3,2],[-2,2]]
    println(s.getDiff(3,2,-2,2))
}