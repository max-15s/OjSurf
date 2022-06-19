// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
class Solution {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val maxCandies = candies.maxOrNull()?: Int.MAX_VALUE
        val result = BooleanArray(candies.size) { false }
        for ((i, v) in candies.withIndex())
            if (v + extraCandies >= maxCandies)
                result[i] = true
        return result.asList()
    }
}