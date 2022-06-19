// https://leetcode.com/problems/shuffle-the-array/

class Solution {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        val result = mutableListOf<Int>()
        for (h1 in 0 until n){
            result.add(nums[h1])
            result.add(nums[h1 + n])
        }
        return result.toIntArray()
    }
}