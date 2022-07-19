// https://leetcode.com/problems/sum-of-all-odd-length-subarrays/

class Solution {
    fun sumOddLengthSubarrays(arr: IntArray): Int {
        var totalSum = 0
        for (i in 1 until arr.size + 1 step 2){
            for (j in arr.indices){
                if (i + j <= arr.size){
                    var sumSub = 0
                    for (k in j until i+j){
                        sumSub += arr[k]
                    }
                    totalSum += sumSub
                }
            }
        }
    return totalSum
    }
}

fun main(){
    var s = Solution()
    println(s.sumOddLengthSubarrays(intArrayOf(1,4,2,5,3)))
}