// 2956 - https://leetcode.com/problems/find-common-elements-between-two-arrays/
class Solution {
    fun findIntersectionValues(nums1: IntArray, nums2: IntArray): IntArray {
        val result = arrayOf(0, 0)
        for ( i in nums1)
            if (nums2.contains(i))
                result[0] += 1

        for ( i in nums2)
            if (nums1.contains(i))
                result[1] += 1
        return result.toIntArray()
    }
}