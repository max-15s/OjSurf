// https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
class Solution {
    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        val sorted = arr.sorted()
        val fixedDiff = sorted[1] - sorted[0]
        for (i in 1 until sorted.size){
            if (sorted[i] - sorted[i-1] != fixedDiff)
                return false
        }
        return true
    }
}