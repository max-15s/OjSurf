// https://leetcode.com/problems/find-all-anagrams-in-a-string/

class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        val toReturn = mutableListOf<Int>()
        val catch = String(p.toCharArray().sortedArray())
        for ( i in 0 until s.length - p.length + 1){
            val subject = s.slice(i until i+p.length)
            if (String(subject.toCharArray().sortedArray()) == catch)
                toReturn.add(i)
        }
        return toReturn
    }
}

fun main(){
    val s = Solution()
    s.findAnagrams("abab", "ab")
}