import java.util.*

// https://leetcode.com/problems/daily-temperatures

class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val s = Stack<Int>()
        val result = IntArray(temperatures.size) { 0 }
        for ((i, v) in temperatures.withIndex()){
            while (!s.isEmpty() && v > temperatures[s.peek()]){
                val k = s.pop()
                result[k] = i - k
            }
            s.push(i)
        }
        return result
    }
}

fun main(){
    val s = Solution()
    for (i in s.dailyTemperatures(intArrayOf(73,74,75,71,69,72,76,73)))
        print(i)
}