// https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val visitSet = mutableSetOf<Char>()
        var head = 0
        var soFar = 0
        var maxLen = 0
        while (soFar < s.length){
            if (visitSet.contains(s[soFar])){
                if (soFar - head > maxLen)
                    maxLen = soFar - head
                while (head < s.length && s[head] != s[soFar])
                    head += 1
                head += 1
                visitSet.clear()
                for ( i in head until soFar)
                    visitSet.add(s[i])
            }
            visitSet.add(s[soFar])
            soFar += 1
        }
        return maxOf(maxLen, visitSet.size)
    }
}

fun main() {
    val s = Solution()
    println(s.lengthOfLongestSubstring("abcabcbb"))
    println(s.lengthOfLongestSubstring("dvdf"))   //  this should result in 3

}
