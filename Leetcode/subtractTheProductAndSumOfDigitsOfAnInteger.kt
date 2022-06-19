// https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
class Solution {
    fun subtractProductAndSum(n: Int): Int {
        var temp = n
        var sumOfDigits = 0
        var productOfDigits = 1
        while ( temp > 9){
            val t = temp % 10
            temp /= 10
            sumOfDigits += t
            productOfDigits *= t
        }
        sumOfDigits += temp
        productOfDigits *= temp

        return productOfDigits - sumOfDigits
    }
}