// 1329 - https://leetcode.com/problems/sort-the-matrix-diagonally/

class Solution {
    fun readFromStartPoint(mat: Array<IntArray>, x: Int, y: Int, xSize: Int, ySize: Int): IntArray {
        val toReturn = mutableListOf<Int>()
        var currentX = x
        var currentY = y
        while (currentX < xSize && currentY < ySize) {
            toReturn.add(mat[currentX][currentY])
            currentY += 1
            currentX += 1
        }
        return toReturn.toIntArray()
    }

    fun writeFromStartPoint(mat: Array<IntArray>, x: Int, y: Int, xSize: Int, ySize: Int, data: IntArray): Array<IntArray> {
        var currentX = x
        var currentY = y
        var dataIndex = 0
        while (currentX < xSize && currentY < ySize) {
            mat[currentX][currentY] = data[dataIndex]
            currentY += 1
            currentX += 1
            dataIndex += 1
        }
        return mat
    }


    fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
        val ySize = mat.first().size
        val xSize = mat.size
        val mutableList = mutableListOf<IntArray>()
        for (i in mat.first().indices) {
            mutableList.add(
                readFromStartPoint(mat, 0, i, xSize, ySize)
            )
        }
        for (i in mat.indices) {
            mutableList.add(
                readFromStartPoint(mat, i, 0, xSize, ySize)
            )
        }

        var cnt = 0
        var currentMat = mat.clone()
        for (i in mat.first().indices) {
            currentMat = writeFromStartPoint(currentMat, 0, i, xSize, ySize, mutableList[cnt].sorted().toIntArray())
            cnt++
        }
        for (i in mat.indices) {
            currentMat = writeFromStartPoint(currentMat, i, 0, xSize, ySize, mutableList[cnt].sorted().toIntArray())
            cnt++
        }

        return mat
    }
}


fun main(args: Array<String>) {
    val s = Solution()
    val t = s.diagonalSort(arrayOf(intArrayOf(3,3,1,1),intArrayOf(2,2,1,2),intArrayOf(1,1,1,2)))
    for (i in t.indices) {
        for (j in t.first().indices) {
            print("${t[i][j]}")
        }
        println()
    }
}

