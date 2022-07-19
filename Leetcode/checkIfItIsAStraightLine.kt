
// https://leetcode.com/problems/check-if-it-is-a-straight-line/
class Solution {
    // pay attention to vertical lines
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        var slop: Double? = null
        if (coordinates[1][0] - coordinates[0][0] != 0)
            slop = (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]).toDouble()
        val x = coordinates[0][0]
        val y = coordinates[0][1]
        if (coordinates.size == 2)
            return true

        for (i in 2 until coordinates.size){
            if (slop != null) {
                if ((coordinates[i][1] - y).toDouble() != (slop * (coordinates[i][0] - x)))
                    return false
            } else {
                if(coordinates[i][0] != x)
                    return false
                }
        }
        return true
    }
}

fun main() {
    val s = Solution()
    println(s.checkStraightLine(arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4), intArrayOf(4,5),
        intArrayOf(5,6),intArrayOf(6,7))))
}