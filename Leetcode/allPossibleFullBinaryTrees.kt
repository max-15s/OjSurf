// 894 - https://leetcode.com/problems/all-possible-full-binary-trees/description/

class TreeNode(var `val`: Int) {
   var left: TreeNode? = null
   var right: TreeNode? = null
}

class Solution {
    fun allPossibleFBT(n: Int): List<TreeNode?> {
        if (n == 1) return listOf(TreeNode(0))
        if (n % 2 == 0) return emptyList()
        val result = mutableListOf<TreeNode>()
        val childNodeCount = n - 1
        // since n cannot be even we jump over them
        for (i in 1 until childNodeCount step 2) {
            val leftChildren = allPossibleFBT(i)
            val rightChildren = allPossibleFBT(n - i - 1)
            if (leftChildren.isEmpty() || rightChildren.isEmpty())
                continue
            for (lchild in leftChildren) {
                for (rchild in rightChildren) {
                    val parent = TreeNode(0).apply {
                        this.left = lchild
                        this.right = rchild
                    }
                    result.add(parent)
                }
            }
        }
        return result
    }
}