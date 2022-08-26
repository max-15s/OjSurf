import kotlin.math.abs

// https://leetcode.com/problems/balanced-binary-tree/


 class TreeNode(var `val`: Int) {
     var left: TreeNode? = null
     var right: TreeNode? = null
 }

 class Solution {
     var isBalanced = true
     fun traverse(node: TreeNode?): Int {
         if (node == null || !isBalanced)
             return 0
         val l = traverse(node.left)
         val r = traverse(node.right)
         if (abs(l - r) > 1)
             isBalanced = false
         return 1 + maxOf(l, r)
     }
    fun isBalanced(root: TreeNode?): Boolean {
        val p = traverse(root)
        return isBalanced
    }
}

fun main(){
    // [3,9,20,null,null,15,7]
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    val c = root.right
    c?.left = TreeNode(15)
    c?.right = TreeNode(7)

    val s = Solution()
    println(s.isBalanced(root))
}