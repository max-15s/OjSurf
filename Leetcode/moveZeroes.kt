// https://leetcode.com/problems/move-zeroes/
class Solution {
    fun moveZeroes(nums: IntArray): Unit {

        for (i in nums.indices){
            for (j in 0 until nums.size - 1){
                if (nums[j] == 0){
                    nums[j] = nums[j+1]
                    nums[j+1] = 0
                }
            }
        }
    }
}