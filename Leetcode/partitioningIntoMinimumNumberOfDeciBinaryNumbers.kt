// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
class Solution {
    fun minPartitions(n: String): Int {
        var maxVal = Int.MIN_VALUE
        n.forEach {
            maxVal = maxOf(maxVal, it.toString().toInt())
        }
        return maxVal
    }
}