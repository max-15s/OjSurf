// https://leetcode.com/problems/smallest-range-ii/

// https://leetcode.com/problems/smallest-range-ii/solutions/989816/explanation-with-pictures-you-can-understand-newmax-vs-newmin-instead-of-i-vs-i-1/
class Solution {
    fun smallestRangeII(nums: IntArray, k: Int): Int {
        if (nums.size <= 1)
            return 0
        nums.sort()
        var currentMin = nums[0] - k
        var currentMax = nums[nums.size - 1] - k
        var currentDiff = currentMax - currentMin
        for (i in 0 until nums.size - 1) {
            currentMax = maxOf(currentMax, nums[i] + k)
            currentMin = minOf(nums[0] + k, nums[i + 1] - k)
            currentDiff = minOf(currentDiff, currentMax - currentMin)
        }
        return currentDiff
    }
}

fun main() {
    val s = Solution()
    print(s.smallestRangeII(intArrayOf(7,8,8), 5))
}