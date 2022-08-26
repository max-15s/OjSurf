class Solution {
    fun isMonotonic(nums: IntArray): Boolean {
        var direction: Boolean? = null
        for ( i in 0..nums.size-2){
            if (nums[i] == nums[i+1])
                continue
            if (direction == null)
                direction = nums[i] < nums[i+1]
            else{
                if (direction != nums[i] < nums[i+1])
                    return false
            }
        }
        return true
    }
}