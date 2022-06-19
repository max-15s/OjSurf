import java.util.*
import kotlin.Comparator

// https://leetcode.com/problems/network-delay-time/
data class P (val to: Int, val totalTime: Int)

class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val visited = mutableSetOf<Int>()
        val adjMatrix = Array(n+1) { IntArray(n+1) {-1} }
        for (item in times){
            adjMatrix[item[0]][item[1]] = item[2]
        }
        val queue = PriorityQueue<P>(compareBy<P>{ it.totalTime })
        queue.add(P(k, 0))
        var totalTime = 0
        while (!queue.isEmpty() && visited.size != n){
            val (currentNode, currenTime) = queue.poll()
            visited.add(currentNode)
            totalTime = currenTime
            for ((child, t) in adjMatrix[currentNode].withIndex()){
                if (t > -1 && !visited.contains(child))
                    queue.add(
                        P(
                            child, currenTime + t
                        )
                    )
            }
        }
        if (visited.size == n)
            return totalTime
        else
            return -1
    }
}

fun main(){
    val s = Solution()
    println(s.networkDelayTime(arrayOf(intArrayOf(1,2,1), intArrayOf(2,3,7), intArrayOf(1,3,4), intArrayOf(2,1,2)), n = 4, k = 1))
}
