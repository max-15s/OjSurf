// https://leetcode.com/problems/running-sum-of-1d-array/

class Solution {
    fun runningSum(nums: IntArray): IntArray {
        val sums = mutableListOf<Int>()
        var soFar = 0
        for (i in nums){
            soFar += i
            sums.add(soFar)
        }
        return sums.toIntArray()
    }
}