package classes


class Solution2 {
    var hashMap = HashMap<Int, IntArray> ()
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for ( (index, value) in nums.withIndex()) {
            var returned = hashMap.get(value)
            if (returned == null)
                hashMap[value] = intArrayOf(index)
            else{
                hashMap[value] = returned.plus(index)
            }
        }
        for ((i , k) in nums.withIndex()){
            val remaining = target - k
            val cached = hashMap[remaining] ?: continue
            if (cached[0] == i)
                if (cached.size > 1)
                    return intArrayOf(cached[0], cached[1])
                else
                    continue
            return intArrayOf(i, cached[0])
        }
        return intArrayOf(-1, -1)
    }
}



fun main(args: Array<String>) {
    // Try adding program arguments at Run/Debug configuration
    val s = Solution2()
    val p = s.twoSum(intArrayOf(3, 3), 6)
    println("[${p.joinToString(", ")}]")
}