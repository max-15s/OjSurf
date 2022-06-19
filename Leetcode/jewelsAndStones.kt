// https://leetcode.com/problems/jewels-and-stones/

class Solution {
    fun numJewelsInStones(jewels: String, stones: String): Int {
//        val pattern = "[$jewels]".toRegex()
//        return pattern.findAll(stones).count()
        var cnt = 0
        for (ch in stones)
            if (jewels.contains(ch))
                cnt += 1
        return cnt
    }
}