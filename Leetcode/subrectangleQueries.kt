// https://leetcode.com/problems/subrectangle-queries/

class SubrectangleQueries(rectangle: Array<IntArray>) {
    val rectangle = rectangle

    fun updateSubrectangle(row1: Int, col1: Int, row2: Int, col2: Int, newValue: Int) {
        for (i in row1 until row2 + 1)
            for (j in col1 until col2 + 1)
                rectangle[i][j] = newValue

    }

    fun getValue(row: Int, col: Int): Int {
        return rectangle[row][col]

    }

}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * var obj = SubrectangleQueries(rectangle)
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue)
 * var param_2 = obj.getValue(row,col)
 */