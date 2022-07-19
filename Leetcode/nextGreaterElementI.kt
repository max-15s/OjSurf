// https://leetcode.com/problems/next-greater-element-i/
class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val toReturn = mutableListOf<Int>()
        for (i in nums1.indices){
            for (j in nums2.indices){
                if (nums1[i] == nums2[j]){
                    var nextGt = -1
                    for (k in j until nums2.size){
                        if (nums2[k] > nums2[j]) {
                            nextGt = nums2[k]
                            break
                        }
                    }
                    toReturn.add(nextGt)
                    break
                }
            }
        }
        return toReturn.toIntArray()
    }
}