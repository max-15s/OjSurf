import java.util.*

// https://leetcode.com/problems/maximum-depth-of-binary-tree/

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    val visit = Stack<Pair<TreeNode, Int>>()
    fun maxDepth(root: TreeNode?): Int {
        var maxDepth = 0
        if (root == null)
            return 0
        visit.push(Pair(root, 1))
        while (!visit.isEmpty()){
            val p = visit.pop()
            if (p.second > maxDepth)
                maxDepth = p.second
            val l = p.first.left
            val r = p.first.right
            if (l != null)
                visit.push(Pair(l, p.second + 1))
            if (r != null)
                visit.push(Pair(r, p.second + 1))
            }
        return maxDepth
    }
}