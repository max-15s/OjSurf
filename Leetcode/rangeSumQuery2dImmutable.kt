// https://leetcode.com/problems/range-sum-query-2d-immutable/

class NumMatrix(matrix: Array<IntArray>) {
    val preSums = Array(matrix.size + 1){ IntArray(matrix[0].size + 1) { 0 } }
    init {
        for ( i in 1 .. matrix.size) {
            for ( j in 1 .. matrix[i].size) {
                preSums[i][j] = preSums[i-1][j] + preSums[i][j-1] + matrix[i-1][j-1] - preSums[i-1][j-1]
            }
        }
    }
    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return preSums[row2 + 1][col2 + 1] - preSums[row1][col2+1] - preSums[row2+1][col1] + preSums[row1][col1]
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */