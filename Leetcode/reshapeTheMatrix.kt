// https://leetcode.com/problems/reshape-the-matrix/
class Solution {
    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        if (mat.size * mat[0].size != r * c)
            return mat
        var m = Array(r) {IntArray(c) {0} }
        var i = 0
        var j = 0
        for (k in mat.indices){
            for ( e in mat[0].indices){
                m[i][j] = mat[k][e]
                j += 1
                if (j == c){
                    j = 0
                    i += 1
                }
            }
        }
        return m
    }
}

fun main(){
    val s = Solution()
    s.matrixReshape(arrayOf(intArrayOf(1,2), intArrayOf(3,4)), 4, 1)
}