import kotlin.math.ceil
import kotlin.math.floor

// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
class Solution {
    fun countOdds(low: Int, high: Int): Int {
        val left = floor(low/2.0).toInt()
        val right = ceil(high/2.0).toInt()
        return right - left
    }
}