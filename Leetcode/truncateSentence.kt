// https://leetcode.com/problems/truncate-sentence/description/
class Solution {
    fun truncateSentence(s: String, k: Int): String {
        val r =  """(\s+)""".toRegex()
        val parts = s.split(regex = r)
        return parts.slice( 0 until k).joinToString(separator = " ")
    }
}


fun main() {
    val s = Solution()
    print(s.truncateSentence("What is the solution to this problem", 4))
}