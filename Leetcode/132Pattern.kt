// https://leetcode.com/problems/132-pattern/
import java.util.*

class Solution {
    var stack = Stack<Int>()
    fun find132pattern(nums: IntArray): Boolean {
        var secondNumber = Int.MIN_VALUE
        for (num in nums.reversed()){
            if (num < secondNumber) return true
            while (!stack.isEmpty() && stack.peek() < num)
                secondNumber = stack.pop()
            stack.push(num)
        }
        return false
    }
}

fun main(){
    val s = Solution()
    println(s.find132pattern(intArrayOf(3,5,0,3,4)))
}