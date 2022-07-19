// https://leetcode.com/problems/contains-duplicate/

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val s = nums.sorted()
        for (i in 0..s.size - 2)
            if (s[i] == s[i+1])
                return true
        return false
    }
}