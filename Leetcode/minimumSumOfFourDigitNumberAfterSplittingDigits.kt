// https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/
class Solution {
    fun minimumSum(num: Int): Int {
        val numAsCharArray = num.toString().toCharArray().sorted().toMutableList()
        val firstNumber = "${numAsCharArray[0]}${numAsCharArray[2]}".toInt()
        val secondNumber = "${numAsCharArray[1]}${numAsCharArray[3]}".toInt()
        return firstNumber + secondNumber
    }
}

fun main() {
    val s = Solution()
    println(s.minimumSum(4009))
}