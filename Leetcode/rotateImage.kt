// https://leetcode.com/problems/rotate-image/
class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        // transpose
        for (i in matrix.indices){
            for (j in i+1 until matrix[i].size){
                val t = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = t
            }
        }

        // reverse
        for (i in matrix.indices)
            for (j in 0 until matrix[i].size/2)
            {
                val t = matrix[i][j]
                matrix[i][j] = matrix[i][matrix[i].size - 1 - j]
                matrix[i][matrix[i].size - 1 - j] = t
            }
//            matrix[i].reverse()
    }
}