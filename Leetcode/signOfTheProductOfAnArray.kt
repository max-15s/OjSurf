// https://leetcode.com/problems/sign-of-the-product-of-an-array/
class Solution {
    fun arraySign(nums: IntArray): Int {
        var product = 1
        nums.forEach {
            if (it > 0)
                product *= 1
            else if (it < 0)
                product *= -1
            else
                return 0
        }
        return product
    }
}