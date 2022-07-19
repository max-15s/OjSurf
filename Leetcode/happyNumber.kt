import kotlin.math.pow

// https://leetcode.com/problems/happy-number/
class Solution {
    val visited = HashMap<Int, Boolean>()
    fun isHappy(n: Int): Boolean {
        var newNum = n
        while (newNum != 1){
            if (visited[newNum] == true)
                return false
            else
                visited[newNum] = true

            var tots = 0
            while ( newNum > 9){
                tots += (newNum % 10.0).pow(2).toInt()
                newNum /= 10
            }
            tots += (newNum % 10.0).pow(2).toInt()
            newNum = tots
        }
        return true
    }
}

fun main() {
    val s = Solution()
    println(s.isHappy(2))
}