// https://leetcode.com/problems/richest-customer-wealth/
class Solution {
    fun maximumWealth(accounts: Array<IntArray>): Int {
        var maxWealth = Int.MIN_VALUE
        for ( row in accounts){
            val total = row.sum()
            if (total > maxWealth)
                maxWealth = total
        }
        return maxWealth
    }
}