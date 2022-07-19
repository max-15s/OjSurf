import java.lang.Math.abs

// https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
class Solution {
    fun nearestValidPoint(x: Int, y: Int, points: Array<IntArray>): Int {
        var minDistance = Int.MAX_VALUE
        var index = -1
        for ((i, p) in points.withIndex()){
            if (x == p[0] || y == p[1]) {
                val d = abs(x - p[0]) + abs(y - p[1])
                if (d < minDistance){
                    minDistance = d
                    index = i
                }
            }
        }
        return index
    }
}