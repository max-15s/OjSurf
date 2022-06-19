import kotlin.math.max

// https://leetcode.com/problems/maximum-erasure-value/
class Solution {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        val visitSet = mutableSetOf<Int>()
        var head = 0
        var soFar = 0
        var maxLen = 0
        var sume = 0
        while (soFar < nums.size){
            if (visitSet.contains(nums[soFar])){
                if (sume > maxLen)
                    maxLen = sume
                while (head < nums.size && nums[head] != nums[soFar]) {
                    visitSet.remove(nums[head])
                    sume -= nums[head]
                    head += 1
                }
                visitSet.remove(nums[head])
                sume -= nums[head]
                head += 1
            }
            visitSet.add(nums[soFar])
            sume += nums[soFar]
            soFar += 1
        }
        return maxOf(sume, maxLen)
    }
}

fun main() {
    val s = Solution()
    println(s.maximumUniqueSubarray(intArrayOf(10000,1,10000,1,1,1,1,1,1)))
}