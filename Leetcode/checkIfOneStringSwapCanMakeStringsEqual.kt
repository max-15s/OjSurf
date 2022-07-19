// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
class Solution {
    fun areAlmostEqual(s1: String, s2: String): Boolean {
        if (s1.length != s2.length)
            return false
        val ss1 = s1.toCharArray().sorted().toCharArray()
        val ss2 = s2.toCharArray().sorted().toCharArray()
        if (String(ss1) != String(ss2))
            return false
        var cnt = 0
        for ((i,ch) in s1.withIndex())
            if (ch != s2[i])
                cnt += 1
        if (cnt > 2)
            return false
        return true
    }
}

fun main() {
    var s = Solution()
    println(s.areAlmostEqual("abca","abcc"))
}