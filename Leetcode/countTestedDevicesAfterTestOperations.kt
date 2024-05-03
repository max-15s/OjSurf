// 2960 - https://leetcode.com/problems/count-tested-devices-after-test-operations/description/

class Solution {
    fun countTestedDevices(batteryPercentages: IntArray): Int {
        var step = 0
        var testedDevicesCount = 0
        for (i in batteryPercentages.indices) {
            if ((batteryPercentages[i] - step) <= 0)
                continue
            else {
                testedDevicesCount += 1
                step += 1
            }
        }
        return testedDevicesCount
    }
}

fun main() {
    val s = Solution()
    println(s.countTestedDevices(arrayOf(1,1,2,1,3).toIntArray()))
}