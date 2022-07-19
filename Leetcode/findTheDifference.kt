// https://leetcode.com/problems/find-the-difference/
class Solution {
    fun findTheDifference(s: String, t: String): Char {
        var sortedS = s.toList().sorted()
        var sortedT = t.toList().sorted()
        for (i in sortedS.indices){
            if (sortedS[i] != sortedT[i])
                return sortedT[i]
        }
        return sortedT[sortedS.size]
    }
}