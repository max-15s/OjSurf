// 3016 - https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/description/

class Solution {
    private fun sortListOfPairs(counts: List<Pair<Char, Int>>): List<Pair<Char, Int>> {
        return counts.sortedWith(compareBy<Pair<Char, Int>> { it.second }.thenBy { it.first }).asReversed()
    }
    fun minimumPushes(word: String): Int {
        val map = mutableMapOf<Char, Int>()
        word.forEach { c ->
            map[c] = map.getOrDefault(c, 0) + 1
        }
        val asSortedList = sortListOfPairs(map.toList())
        var row = 1
        var cnt = 2
        var sum = 0
        for (it in asSortedList) {
            sum += row * it.second
            cnt += 1
            if (cnt == 10) {
                cnt = 2
                row += 1
            }
        }
        return sum
    }
}

fun main() {
    println(Solution().minimumPushes("aabbccddeeffgghhiiiiii"))
}