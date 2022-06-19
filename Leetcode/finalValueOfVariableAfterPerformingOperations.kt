// https://leetcode.com/problems/final-value-of-variable-after-performing-operations/

class Solution {
    fun finalValueAfterOperations(operations: Array<String>): Int {
        var x = 0
        for ( op in operations){
            if (op[0] == '+'|| op[2] == '+')
                x += 1
            else
                x -= 1
        }
        return x
    }
}