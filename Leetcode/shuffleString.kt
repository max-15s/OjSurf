// 1528 - https://leetcode.com/problems/shuffle-string/
class Solution {
    fun restoreString(s: String, indices: IntArray): String {
        val chars = arrayOfNulls<Char>(s.length)
        var cnt = 0
        for (i in indices) {
            chars[i] = s[cnt]
            cnt += 1
        }
        return chars.joinToString("")
    }
}

fun main() {
    val solution = Solution()
    println(solution.restoreString( "codeleet", intArrayOf(4,5,6,7,0,2,1,3)))
    println(solution.restoreString( "abc", intArrayOf(0,1,2)))
}