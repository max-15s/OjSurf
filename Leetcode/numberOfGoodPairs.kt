// https://leetcode.com/problems/number-of-good-pairs/

class Solution {
    fun numIdenticalPairs(nums: IntArray): Int {
        var cnt = 0
        for ( i in nums.indices)
            for (j in i+1 until nums.size)
                if (nums[i] == nums[j])
                    cnt += 1
        return cnt

    }
}