import java.util.*

// https://leetcode.com/problems/deepest-leaves-sum/
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
class Solution {
    fun deepestLeavesSum(root: TreeNode?): Int {
        val q = Stack<Pair<Int,TreeNode>>()
        var sum = 0
        var maxDepth = 0
        val t = Pair(0, root)
        q.push(t as Pair<Int, TreeNode>?)
        while (!q.isEmpty()){
            val (d, p) = q.pop()
            if (p.right == null && p.left == null) {
                if (d == maxDepth)
                    sum += p.`val`
                else if (d > maxDepth) {
                    sum = p.`val`
                    maxDepth = d
                }

            }
            else {
                if (p.right != null) {
                    val _t = Pair(d+1, p.right)
                    q.push(_t as Pair<Int, TreeNode>?)
                }
                if (p.left != null)
                {
                    val _t = Pair(d+1, p.left)
                    q.push(_t as Pair<Int, TreeNode>?)
                }
            }
        }
        return sum
    }
}