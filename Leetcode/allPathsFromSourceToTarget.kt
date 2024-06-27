import java.util.*

// 797 - https://leetcode.com/problems/all-paths-from-source-to-target/description/
class Solution {
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        // Based on the definition of the graph we don't need track which vertices are visited
        val result = mutableListOf<List<Int>>()
        val nodeToPathStack = Stack<Pair<Int, MutableList<Int>>>()
        nodeToPathStack.push(0 to intArrayOf(0).toMutableList())
        while (nodeToPathStack.isNotEmpty()) {
            val (node, path) = nodeToPathStack.pop()
            if (node == graph.lastIndex)
                result.add(path.toList())
            else {
                for (neighbor in graph[node]) {
                    val pathCopy = path + neighbor
                    nodeToPathStack.push(neighbor to pathCopy.toMutableList())
                }
            }
        }
        return result.toList()
    }
}

fun main() {
    val solution = Solution()
    println(solution.allPathsSourceTarget(arrayOf(intArrayOf(1,2), intArrayOf(3), intArrayOf(3), intArrayOf())))
}