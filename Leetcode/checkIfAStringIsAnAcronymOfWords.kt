// 2828 - https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/description/
class Solution {
    fun isAcronym(words: List<String>, s: String): Boolean {
        return words.map { it[0] }.joinToString("") == s
    }
}

fun main() {
    val s = Solution()
    s.isAcronym(listOf("alice","bob","charlie"), "abc")
}