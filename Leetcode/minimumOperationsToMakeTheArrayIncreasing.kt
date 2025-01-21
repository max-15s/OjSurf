// 1827 - https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/

class Solution {
    fun minOperations(nums: IntArray): Int {
        var lastValue = nums[0]
        var total = 0
        var index: Int? = null
        for (i in 0 ..< nums.size - 1) {
            if (nums[i] < nums[i+1]) continue
            index = i
            break
        }

        if (index != null) {
            lastValue = nums[index]
            for (i in index + 1 ..< nums.size ) {
                val next = lastValue + 1
                if (next <= nums[i])
                    lastValue = nums[i]
                else {
                    total += next - nums[i]
                    lastValue = next
                }
            }
        }
        return total
    }
}

fun main() {
    println(Solution().minOperations(intArrayOf(1,1,1)))
    println(Solution().minOperations(intArrayOf(1,5,2,4,1)))
    println(Solution().minOperations(intArrayOf(8)))
}