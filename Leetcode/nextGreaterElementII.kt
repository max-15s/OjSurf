import java.util.*

// https://leetcode.com/problems/next-greater-element-ii/
class Solution {
    fun nextGreaterElements(nums: IntArray): IntArray {
        val s = Stack<Int>()
        val answer = IntArray(nums.size) { -1 }
        for (j in 0 until 2) {
            for ((i, v) in nums.reversed().withIndex()) {
                while (!s.isEmpty() && s.peek() <= v)
                    s.pop()
                if (s.isEmpty())
                    answer[i] = -1
                else
                    answer[i] = s.peek()
                s.add(v)
            }
        }
        return answer
    }
}


// https://leetcode.com/problems/next-greater-element-ii/
//class Solution {
//    fun nextIndex(i: Int, n: Int): Int {
//        return (i + 1) % n
//    }
//    fun nextGreaterElements(nums: IntArray): IntArray {
//        val answer = IntArray(nums.size) { -1 }
//        for ((i, v) in nums.withIndex()){
//            var index = nextIndex(i, nums.size)
//            while (index != i){
//                if (nums[index] > v){
//                    answer[i] = nums[index]
//                    break
//                }
//                index = nextIndex(index, nums.size)
//            }
//        }
//        return answer
//    }
//}

fun main(){
    var s = Solution()
    for (i in s.nextGreaterElements(intArrayOf(1,2,1)))
        println(i)
}