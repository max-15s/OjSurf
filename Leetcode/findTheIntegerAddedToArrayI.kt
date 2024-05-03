// 3131 - https://leetcode.com/problems/find-the-integer-added-to-array-i/description/
class Solution {
    fun addedInteger(nums1: IntArray, nums2: IntArray): Int {
        return (nums2.sum() - nums1.sum())/nums1.size
    }
}