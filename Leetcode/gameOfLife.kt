import kotlin.collections.arrayListOf as arrayListOf

class Solution {
    fun sumOfNeighborhood(x: Int, y: Int, board: Array<IntArray>): Int {
        var sum = 0
        for (i in x - 1 .. x + 1)
            for (j in y - 1 .. y + 1)
                if (i == x && j == y)
                    continue
                else if ( 0 <= i && i < board.size && 0 <= j && j < board[i].size)
                    sum += board[i][j]
        return sum
    }

    fun gameOfLife(board: Array<IntArray>): Unit {
        var nextGeneration = Array(board.size) {Array(board[0].size) {0} }
        for (x in 0..board.size-1){
            for (y in 0..board[x].size-1){
                nextGeneration[x][y] = sumOfNeighborhood(x, y, board)
            }
        }
        for (x in 0..board.size-1){
            for (y in 0..board[x].size-1){
                if (nextGeneration[x][y] < 2)
                    board[x][y] = 0
                else if (nextGeneration[x][y] < 3)
                    board[x][y] = board[x][y]
                else if (nextGeneration[x][y] == 3)
                    board[x][y] = 1
                else
                    board[x][y] = 0
            }
        }
    }
}

fun main() {
    val s = Solution()
    val board = arrayOf(intArrayOf(0,1,0), intArrayOf(0,0,1), intArrayOf(1,1,1), intArrayOf(0,0,0))
    print(s.sumOfNeighborhood(0,0, board))

    for (x in 0..board.size-1){
        for (y in 0..board[x].size-1)
            print("${board[x][y]} ")
        println()
    }

    s.gameOfLife(board)
    println("************")
    for (x in 0..board.size-1){
        for (y in 0..board[x].size-1)
            print("${board[x][y]} ")
        println()
    }
}