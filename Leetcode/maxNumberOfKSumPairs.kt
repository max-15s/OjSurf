//https://leetcode.com/problems/max-number-of-k-sum-pairs/
class Solution {
   fun maxOperations(nums: IntArray, k: Int): Int {
       val sorted = nums.sorted()
       var total = 0
       var head = 0
       var tail = sorted.lastIndex
       while ( head < tail){
           val ws = sorted[tail] + sorted[head]
           if ( ws > k)
               tail -= 1
           else if ( ws < k)
               head += 1
           else{
               total += 1
               head += 1
               tail -= 1
           }
       }
        return total
    }
}

fun main(){
    val s = Solution()
    print(s.maxOperations(intArrayOf(3,1,3,4,3), 6))
}