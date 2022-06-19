//https://leetcode.com/problems/number-of-1-bits/
class Solution {
    // you need treat n as an unsigned value
    fun hammingWeight(n:Int):Int {
        var num = n
        var count = 0
        for (i in 1..32)
            if (num shr i and 1 == 1)
                count += 1
        return count
    }
}

fun main() {
    val n = 1
    for (i in 0..31)
        println(n shr i and 1)
}