//https://leetcode.com/problems/permutations-ii/
class Solution {
    val toReturn = mutableListOf<IntArray>()
    val unify = HashMap<String, Int>()
    fun heapFunc(nums: IntArray, arraySize: Int, n: Int){
        if ( arraySize <= 1 ){
            val key = nums.joinToString("_")
            if ( unify[key] == null) {
                toReturn.add(nums.clone())
                unify[key] = 0
            }
        }else {
            for (i in 0 until arraySize){
                heapFunc(nums, arraySize - 1, n)
                if (arraySize % 2 == 1){
                    val t = nums[0]
                    nums[0] = nums[arraySize-1]
                    nums[arraySize-1] =t
                }else{
                    val t = nums[i]
                    nums[i] = nums[arraySize-1]
                    nums[arraySize-1] = t
                }
            }
        }

    }

    fun permuteUnique(nums: IntArray): List<IntArray> {
        heapFunc(nums, nums.size, nums.size)
        return toReturn.toList()
    }

    fun swap(nums: IntArray, i: Int, j: Int):Unit{
        val tmp = nums[i]
        nums[i] = nums[j]
        nums[j] = tmp
    }

    fun dfs(nums: IntArray, index: Int): Unit {
        if (index == nums.size) {
            println(nums.joinToString(" "))
            return
        }
        for (i in index until nums.size) {
            swap(nums, i, index)
            dfs(nums, index + 1)
            swap(nums, i, index)
        }
    }


}


fun main(){
    val s = Solution()
    val si = s.permuteUnique(intArrayOf(1,1,2))
//    for (i in si){
//        println(i.joinToString(" "))
//    }
    s.dfs(intArrayOf(1,3,2), 0)
}