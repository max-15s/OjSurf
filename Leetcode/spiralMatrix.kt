// https://leetcode.com/problems/spiral-matrix/
class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val res = mutableListOf<Int>()
        var startX = 0
        var startY = 0
        var loopSizeX = matrix.size - 1
        var loopSizeY = matrix[0].size - 1

        val xSteps = intArrayOf(0, 1, 0, -1)
        val ySteps = intArrayOf(1, 0, -1, 0)
        while (res.size < matrix.size * matrix[0].size) {
            res.add(matrix[startX][startY])
            var currentX = startX
            var currentY = startY
            for (i in xSteps.indices) {
                if (xSteps[i] != 0)
                    for (j in 0 until loopSizeX) {
                        if (res.size == matrix.size * matrix[0].size)
                            break
                        if (currentX + xSteps[i] != startX || currentY + ySteps[i] != startY) {
                            currentX += xSteps[i]
                            currentY += ySteps[i]
                            res.add(matrix[currentX][currentY])
                        }
                    }
                else {
                    if (res.size == matrix.size * matrix[0].size)
                        break
                    for (j in 0 until loopSizeY) {
                        currentX += xSteps[i]
                        currentY += ySteps[i]
                        res.add(matrix[currentX][currentY])
                    }
                }
            }
            startX += 1
            startY += 1
            loopSizeX -= 2
            loopSizeY -= 2
        }

        return res
    }
}

fun main(){
    val s = Solution()
//    for (c in s.spiralOrder((arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9)))))
//        print("${c}, ")

    for (c in s.spiralOrder(arrayOf(intArrayOf(1,2,3,4), intArrayOf(5,6,7,8), intArrayOf(9,10,11,12))))
        print("${c}, ")
}