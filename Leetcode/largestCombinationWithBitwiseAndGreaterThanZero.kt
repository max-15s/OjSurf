// 2275 - https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/description/


class Solution {
    fun largestCombination(candidates: IntArray): Int {
        var maxSize = 0
        for (i in 0 until 32) {
            val mask = 1 shl (i)
            val count = candidates.filter { it and mask != 0 }
            maxSize = maxOf(maxSize, count.size)
        }
        return maxSize
    }
}