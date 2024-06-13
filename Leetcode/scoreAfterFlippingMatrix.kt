// 861 - https://leetcode.com/problems/score-after-flipping-matrix/description/
class Solution {
    fun shouldSwitch(matrix: Array<IntArray>, col: Int): Boolean {
        val (ones, zeros) = IntArray(matrix.size) { matrix[it][col] }.partition { it == 1 }
        return ones.size < zeros.size

    }
    fun matrixScore(grid: Array<IntArray>): Int {
        // all rows starting with 0 should be toggled
        for (i in grid.indices) {
            if (grid[i][0] == 0) {
                for (j in grid[i].indices) {
                    grid[i][j] = if (grid[i][j] == 0) 1 else 0
                }
            }
        }

        // to change columns, we do it if there are more 0 than 1
        for(i in grid.first().indices) {
            if (shouldSwitch(grid, i)) {
                for (j in grid.indices) {
                    grid[j][i] = if (grid[j][i] == 0) 1 else 0
                }
            }
        }
        var score = 0
        for (i in grid.indices) {
            score += grid[i].joinToString("").toInt(2)
        }
        return score
    }
}

fun main() {
    val solution = Solution()
    println(solution.matrixScore(arrayOf(intArrayOf(0,0,1,1), intArrayOf(1,0,1,0), intArrayOf(1,1,0,0))))
    /*
    Input: grid = [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
    Output: 39
    Explanation: 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39

    Input: grid = [[0]]
    Output: 1
     */


}
