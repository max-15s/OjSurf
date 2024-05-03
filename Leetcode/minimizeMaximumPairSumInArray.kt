// 1877 - https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/description/
class Solution {
    fun minPairSum(nums: IntArray): Int {
        val sortedNums = nums.sorted()
        var maxPair = sortedNums.first() + sortedNums.last()
        val si = sortedNums.size - 1
        for ( i in 0 .. sortedNums.size/2) {
            if (sortedNums[i] + sortedNums[si - i] > maxPair)
                maxPair = sortedNums[i] + sortedNums[si - i]
        }
        return maxPair
    }
}