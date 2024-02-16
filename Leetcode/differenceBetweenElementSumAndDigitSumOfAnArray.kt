import kotlin.math.abs

// 2535 - https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/description/
class Solution {

    fun digitSumOf(num: Int): Int {
        var sum = 0
        var tnum = num
        while (tnum > 0) {
            sum += tnum % 10
            tnum /= 10
        }
        return sum
    }

    fun differenceOfSum(nums: IntArray): Int {
        var elementSum = 0
        var digitSum = 0
        for ( n in nums ) {
            elementSum += n
            digitSum += digitSumOf(n)
        }
        return abs(elementSum - digitSum)
    }
}

