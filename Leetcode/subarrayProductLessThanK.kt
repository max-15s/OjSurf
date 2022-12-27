// https://leetcode.com/problems/subarray-product-less-than-k

class Solution {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        if ( k <= 1) return 0
        var prod = 1
        var cnt = 0
        var left = 0
        for ( right in nums.indices){
            prod *= nums[right] // expansion
            while ( prod >= k){  // shrinkage
                prod /= nums[left]
                left += 1
            }
            if ( prod < k)
                cnt += (right - left + 1)
        }
        return cnt
    }
}

// https://leetcode.com/problems/subarray-product-less-than-k/solutions/1567051/python-90-easiest-10-line-code-explained-with-example/
fun main(){
    val s = Solution()
    print(s.numSubarrayProductLessThanK(intArrayOf(10,5,2,6), 100))
//    print(s.numSubarrayProductLessThanK(intArrayOf(10,9,10,4,3,8,3,3,6,2,10,10,9,3), 19))
}