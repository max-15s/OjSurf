import java.util.*

// https://leetcode.com/problems/seat-reservation-manager/

class SeatManager(n: Int) {

    val minHeap = PriorityQueue<Int>()
    init {
        for (i in 1..n)
            minHeap.add(i)
    }

    fun reserve(): Int {
        return minHeap.poll()
    }

    fun unreserve(seatNumber: Int) {
        minHeap.add(seatNumber)
    }
}

fun main(){
    val obj = SeatManager(5)
    for (i in 0..5)
        println(obj.reserve())
}