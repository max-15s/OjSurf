// 1347 - https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/description/
class Solution {
    val cntMap = HashMap<Char, Int>()
    fun minSteps(s: String, t: String): Int {
        for (c in t) {
            cntMap[c] = cntMap.getOrDefault(c, 0) + 1
        }
        var changes = 0
        for (c in s) {
            val cnt = cntMap.getOrDefault(c, 0)
            if (cnt > 0)
                cntMap[c] = cnt - 1
            else
                changes += 1
        }
        return changes
    }
}