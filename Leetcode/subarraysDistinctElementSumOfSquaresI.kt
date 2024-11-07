// 2913 - https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/description/

class Solution {
    fun sumCounts(nums: List<Int>): Int {
        var head = 0
        var tail = 0
        var totalSum = 0
        for (i in nums.indices) {
            for (j in i+1 .. nums.size) {
                val subArray = nums.subList(i, j)
                val count = subArray.toSet().size
                totalSum += (count * count)
            }
        }
        return totalSum
    }
}


fun main() {
    val solution = Solution()
    println(solution.sumCounts(listOf(1,2,1)))
}