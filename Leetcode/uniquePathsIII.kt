// 980 - https://leetcode.com/problems/unique-paths-iii/description/


class Solution {
    /*
    1: starting point
    2: end point
    0: empty
    -1: obstacle

    // this is track back algorithm. but we want number of paths that are visiting all empty cells
     */
    fun visit(grid: Array<IntArray>, x: Int, y: Int, leftToVisit: Int): Int {
        if (x !in grid.indices || y !in grid[x].indices) return 0
        if (grid[x][y] == 2)
            return if (leftToVisit == 0) 1 else 0
        if (grid[x][y] < 0) return 0
        val current = grid[x][y]
        grid[x][y] = -2
        val path = visit(grid, x - 1, y, leftToVisit - 1) +
                   visit(grid, x, y - 1, leftToVisit - 1) +
                   visit(grid, x + 1, y, leftToVisit - 1) +
                   visit(grid, x, y + 1, leftToVisit - 1)
        grid[x][y] = current
        return path
    }


    fun uniquePathsIII(grid: Array<IntArray>): Int {
        var totalToVisit = 1  // we are in first cell witch is 1, and we visit it. in line 20 we have decreased left to
        // visits but we are changing a 1 into -2 not a 0
        var startX = 0
        var startY = 0
        for (row in grid.indices) {
            for (column in grid[row].indices) {
                if (grid[row][column] == 0) {
                    totalToVisit += 1
                }
                if (grid[row][column] == 1) {
                    startX = row
                    startY = column
                }
            }
        }

        return visit(grid, startX, startY, totalToVisit)
    }
}

fun main() {
    val s = Solution()
//    println(s.uniquePathsIII(arrayOf(intArrayOf(0,1),intArrayOf(2,0))))  // 2
//    println(s.uniquePathsIII(arrayOf(intArrayOf(1,0,0,0),intArrayOf(0,0,0,0),intArrayOf(0,0,0,2))))  // 4
    println(s.uniquePathsIII(arrayOf(intArrayOf(1,0,0,0),intArrayOf(0,0,0,0),intArrayOf(0,0,2,-1))))  // 2
}