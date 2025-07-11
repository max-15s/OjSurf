// 2125: https://leetcode.com/problems/number-of-laser-beams-in-a-bank/
class Solution {
    fun numberOfBeams(bank: Array<String>): Int {
        val rowCameraCount = bank.map { row -> row.count { c -> c == '1' } }.filterNot { it == 0 }
        var total = 0
        for (i in 0..< rowCameraCount.lastIndex)
            total += (rowCameraCount[i] * rowCameraCount[i + 1])
        return total
    }
}

fun main() {
    val s = Solution().numberOfBeams(arrayOf("011001","000000","010100","001000"))
}