class Solution {
    fun buildArray(nums: IntArray): IntArray {
        val toReturn = IntArray(nums.size)
        for ((i, v) in nums.withIndex()){
            toReturn[i] = nums[v]
        }
        return toReturn
    }
}


fun main(){
    val a = intArrayOf(0,2,1,5,3,4)
    val s = Solution()
    s.buildArray(a)
}