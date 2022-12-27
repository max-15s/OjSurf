import java.util.*

// https://leetcode.com/problems/time-needed-to-inform-all-employees/
class Solution {
    fun getTime(current: Int, headID: Int, manager: IntArray, informTime: IntArray, passedTime: IntArray): Int {
        if (current == headID)
            return 0
        if (passedTime[manager[current]] != -1){
            passedTime[current] = passedTime[manager[current]] + informTime[manager[current]]
            return passedTime[current]
        }else {
            passedTime[manager[current]] = getTime(manager[current], headID, manager, informTime, passedTime)
            passedTime[current] = passedTime[manager[current]] + informTime[manager[current]]
            return passedTime[current]
        }
    }
    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
        val passedTime = IntArray(informTime.size) { -1 }
        for (c in manager.indices){
            if (passedTime[c] == -1)
                passedTime[c] = getTime(c, headID, manager, informTime, passedTime)
        }
        return passedTime.maxOrNull()?:0
    }
}

fun main(){
    val s = Solution()
    println(s.numOfMinutes(n = 6, headID = 2, manager = intArrayOf(2,2,-1,2,2,2), informTime = intArrayOf(0,0,1,0,0,0)))
}
