import kotlin.math.abs

// 2073: https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/description/
class Solution {
    fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
        val sortedSeats = seats.sorted()
        val sortedStudents = students.sorted()

        var totalMoves = 0
        for (i in sortedSeats.indices) {
            totalMoves += abs(sortedSeats[i] - sortedStudents[i])
        }
        return totalMoves
    }
}