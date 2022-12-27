import kotlin.math.sqrt

class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        var sortedList = points
            .sortedWith <IntArray> (object : Comparator <IntArray> {
                override fun compare (p0: IntArray, pi: IntArray) : Int {
                    var v0 = sqrt((p0[0] * p0[0]).toFloat() + (p0[1] * p0[1]))
                    var vi = sqrt((pi[0] * pi[0]).toFloat() + (pi[1] * pi[1]))
                    if (v0 > vi) {
                        return 1
                    }
                    if (v0 == vi) {
                        return 0
                    }
                    return -1
                }
            })

        return sortedList.subList(0, k).toTypedArray()
    }
}