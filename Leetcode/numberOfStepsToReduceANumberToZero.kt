// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
class Solution {
    fun numberOfSteps(num: Int): Int {
        var cnt = 0
        var tmp = num
        while (tmp > 0){
            cnt += 1
            if (tmp % 2 == 0)
                tmp /= 2
            else
                tmp -= 1
        }
        return cnt
    }
}

fun main(){
    var s = Solution()
    println(s.numberOfSteps(0))
}