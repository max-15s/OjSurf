// 2442 - https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations/description/
class Solution {
    fun countDistinctIntegers(nums: IntArray): Int {
        val results = mutableSetOf<Int>()
        for (num in nums) {
            results.add(num)
            results.add(
                num.toString().reversed().toInt()
            )
        }
        return results.count()
    }
}