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

class Solution1 {
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        while (root != null){
            if (root.`val` == `val`)
                return root
            if (root.`val` > `val`)
                return searchBST(root.left, `val`)
            else
                return searchBST(root.right, `val`)
        }
        return root
    }
}