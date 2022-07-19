// https://leetcode.com/problems/matrix-diagonal-sum/

class Solution {
    fun diagonalSum(mat: Array<IntArray>): Int {
        var totalSum = 0
        for ( i  in mat.indices){
            totalSum += mat[i][i]
            if ( i != (mat.size - 1 - i))
                totalSum += mat[mat.size - 1 - i][i]
        }
        return  totalSum
    }
}