// 1844 - https://leetcode.com/problems/replace-all-digits-with-characters/description/

class Solution {
    fun replaceDigits(s: String): String {
        val raw = s.toCharArray()
        for (c in 0 until raw.size step 2) {
            if (c + 1 >= raw.size) continue
            val char = raw[c].code
            val digit = (raw[c + 1]).toString().toInt()
            raw[c+1] = (char + digit).toChar()
        }
        return raw.joinToString("")
    }
}

fun main() {
    val solution = Solution()
    println(solution.replaceDigits("a1b2c3d4e"))
}