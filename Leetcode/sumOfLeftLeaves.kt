import java.util.*

// https://leetcode.com/problems/sum-of-left-leaves/

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
class Solution {
    val visit = Stack<TreeNode>()
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        if (root == null)
            return 0
        var maxSum = 0
        if (root.left == null && root.right == null)
            return 0
        visit.push(root)
        while (!visit.isEmpty()){
            val p = visit.pop()
            if (p.left != null){
                if (p.left!!.left == null && p.left!!.right == null){
                    maxSum += p!!.left?.`val` ?: 0
                }
            }
            if (p.left != null)
                visit.push(p.left)
            if (p.right != null)
                visit.push(p.right)
        }
        return maxSum
    }
}

fun main(){
    val r = TreeNode(3)
    r.left = TreeNode(9)
    r.right = TreeNode(20)
    val p = r.right
    p!!.left = TreeNode(15)
    p!!.right = TreeNode(7)
    val s = Solution()
    println(s.sumOfLeftLeaves(r))
}