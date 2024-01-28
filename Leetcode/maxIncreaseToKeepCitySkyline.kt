// https://leetcode.com/problems/max-increase-to-keep-city-skyline/description/
class Solution {
    fun maxWest(grid: Array<IntArray>): IntArray {
        val row = IntArray(grid.size) { 0 }
        for (i in grid.indices) {
            for ( j in grid.first().indices){
                if (row[i] < grid[i][j])
                    row[i] = grid[i][j]
            }
        }
        return row
    }

    fun maxEast(grid: Array<IntArray>): IntArray {
        val row = IntArray(grid.size) { 0 }
        for (i in grid.indices) {
            for ( j in grid.first().size - 1 downTo 0){
                if (row[i] < grid[i][j])
                    row[i] = grid[i][j]
            }
        }
        return row
    }

    fun maxNorth(grid: Array<IntArray>): IntArray {
        val row = IntArray(grid.first().size) { 0 }
        for (i in grid.first().indices) {
            for ( j in grid.indices){
                if (row[i] < grid[j][i])
                    row[i] = grid[j][i]
            }
        }
        return row
    }

    fun maxSouth(grid: Array<IntArray>): IntArray {
        val row = IntArray(grid.first().size) { 0 }
        for ( j in grid.size - 1 downTo 0){
            for (i in grid.first().indices) {
                if (row[j] < grid[i][j])
                    row[j] = grid[i][j]
            }
        }
        return row
    }
    fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
        val north = maxNorth(grid)
        val east = maxEast(grid)
        var total = 0
        for (i in grid.indices) {
            val maxN = north[i]
            for (j in grid.indices) {
                val maxE = east[j]
                total += ( minOf(maxE, maxN) - grid[i][j])
            }
        }
        return total
        

    }
}


fun main() {
    val s = Solution()
    val g = arrayOf(intArrayOf(3,0,8,4), intArrayOf(2,4,5,7), intArrayOf(9,2,6,3), intArrayOf(0,3,1,0))

    val k = s.maxNorth(g)
    for (i in k)
        println(i)

    println(s.maxIncreaseKeepingSkyline(g))

}