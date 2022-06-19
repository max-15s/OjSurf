class UndergroundSystem() {
    val data = HashMap<String, IntArray>()
    val checkins = HashMap<Int, HashMap<String, String>>()

    fun checkIn(id: Int, stationName: String, t: Int) {
        val tmp = HashMap<String, String>()

        tmp["s"] = stationName
        tmp["t"] = t.toString()
        checkins[id] = tmp
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val checkin = checkins[id]
        if (checkin == null)
            return
        val dataKey = checkin["s"] + "->" + stationName
        val previous = data[dataKey]
        if (previous == null) {
            data[dataKey] = intArrayOf(t - (checkin["t"]?.toInt() ?: 0)).also { data[dataKey] = it }
        }
        if (previous != null) {
            data[dataKey] = previous + intArrayOf(t - (checkin["t"]?.toInt() ?: 0)).also { data[dataKey] = it }
        }
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        val dataKey = "$startStation->$endStation"
        val times = data[dataKey] ?: return -1.0
        return times.sum().toDouble() / times.size


    }

}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * var obj = UndergroundSystem()
 * obj.checkIn(id,stationName,t)
 * obj.checkOut(id,stationName,t)
 * var param_3 = obj.getAverageTime(startStation,endStation)
 */

fun main() {
    val undergroundSystem = UndergroundSystem()
    undergroundSystem.checkIn(10, "Leyton", 3)
    undergroundSystem.checkOut(10, "Paradise", 8) // Customer 10 "Leyton" -> "Paradise" in 8-3 = 5

    println(undergroundSystem.getAverageTime("Leyton", "Paradise")) // return 5.00000, (5) / 1 = 5

    undergroundSystem.checkIn(5, "Leyton", 10)
    undergroundSystem.checkOut(5, "Paradise", 16) // Customer 5 "Leyton" -> "Paradise" in 16-10 = 6

    print(undergroundSystem.getAverageTime("Leyton", "Paradise")) // return 5.50000, (5 + 6) / 2 = 5.5

    undergroundSystem.checkIn(2, "Leyton", 21)
    undergroundSystem.checkOut(2, "Paradise", 30) // Customer 2 "Leyton" -> "Paradise" in 30-21 = 9

    println(undergroundSystem.getAverageTime("Leyton", "Paradise")) // return 6.66667, (5 + 6 + 9) / 3 = 6.66667


}