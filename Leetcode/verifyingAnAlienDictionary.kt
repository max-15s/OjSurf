// https://leetcode.com/problems/verifying-an-alien-dictionary/
class Solution {
    fun comp(word1: String, word2: String, order: String): Boolean {
        var oneHead = 0
        var twoHead = 0
        var cHead = 0
        while (true){
            if (oneHead >= word1.length)
                return true
            if (twoHead >= word2.length)
                return false
            var c = order[cHead]
            cHead += 1
            if (word1[oneHead] != c && word2[twoHead] != c)
                continue
            if (word1[oneHead] == c && word2[twoHead] == c){
                oneHead += 1
                twoHead += 1
                cHead = 0
            }else return word1[oneHead] == c && word2[twoHead] != c


        }
    }
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        for (i in 0 until words.size-1){
            if (!comp(words[i], words[i+1], order))
                return false
        }
        return true
    }
}

fun main() {
    val s = Solution()
    println(s.isAlienSorted(arrayOf("kuvp","q"),"ngxlkthsjuoqcpavbfdermiywz"))
    println(s.comp("hello","leetcode", order = "hlabcdefgijkmnopqrstuvwxyz"))
    println(s.comp("word","world", order = "worldabcefghijkmnpqstuvxyz"))
    println(s.comp("apple","app", order = "abcdefghijklmnopqrstuvwxyz"))
}