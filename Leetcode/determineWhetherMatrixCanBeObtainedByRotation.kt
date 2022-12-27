// https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/

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

    fun matEq(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
        for ( i in mat.indices)
            for (j in mat[i].indices)
                if (mat[i][j] != target[i][j])
                    return false
        return true
    }
    fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
        for (i in 0..4){
            if (matEq(mat, target))
                return true
            rotate(mat)
        }
        return false
    }
}