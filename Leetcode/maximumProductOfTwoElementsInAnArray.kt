// 1464 - https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/description/
class Solution {
    fun maxProduct(nums: IntArray): Int {
        var max1 = nums.toList().subList(0, 2).max()
        var max2 = nums.toList().subList(0, 2).min()
        for (it in nums.toList().subList(2, nums.size)) {
            if ( max2 < it && it < max1) max2 = it
            if (it >= max1) {
                if (max1 > max2) max2 = max1
                max1 = it
            }
        }
        return (max1-1) * (max2-1)
    }
}

fun main() {
    val solution = Solution()
    println(solution.maxProduct(intArrayOf(10,2,5,2)))
}