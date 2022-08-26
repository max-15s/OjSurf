// https://leetcode.com/problems/range-sum-query-immutable/
class NumArray(nums: IntArray) {
    val nums = nums
    fun sumRange(left: Int, right: Int): Int {
        var s = 0
        for ( i in left..right){
            s += nums[i]
        }
        return s
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */