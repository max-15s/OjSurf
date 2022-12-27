// https://leetcode.com/problems/arithmetic-subarrays/
class Solution {
    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
        val res = List<Boolean>(l.size) { true }.toMutableList()
        for (i in l.indices){
            val s = nums.slice(l[i] .. r[i]).sorted()
            val diff = s[1] - s[0]
            for (j in 1 until s.size)
                if ( s[j] - s[j-1] != diff){
                    res[i] = false
                    break
                }
        }
        return res
    }
}