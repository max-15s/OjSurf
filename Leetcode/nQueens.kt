import java.util.*

//https://leetcode.com/problems/n-queens/
class Solution {
    val columns = Stack<Int>()
    val diagonal = Stack<Int>()
    val antiDiagonal = Stack<Int>()
    val endResult = mutableListOf<List<String>>()

    fun traverse(row: Int, n: Int){
        if (row == n){
            val snap = mutableListOf<String>()
            for (item in columns){
                val _str = ".".repeat(n)
                snap.add(StringBuilder(_str).also { it.setCharAt(item, 'Q') }.toString())
            }
            endResult.add(snap.toList())
        }
        for (col in 0 until n )
            if (!columns.contains(col)){
                val diff = row - col
                val sum = row + col
                if (!diagonal.contains(sum) && !antiDiagonal.contains(diff)){
                    columns.push(col)
                    diagonal.push(sum)
                    antiDiagonal.push(diff)
                    traverse(row + 1, n)
                    columns.pop()
                    diagonal.pop()
                    antiDiagonal.pop()
                }
            }
    }
    fun solveNQueens(n: Int): List<List<String>> {
        traverse(0, n)
        return endResult
    }
}

fun main() {
    val s = Solution()
    print(s.solveNQueens(1))
}