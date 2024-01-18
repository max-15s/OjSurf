import java.util.*

// https://leetcode.com/problems/binary-search-tree-iterator/

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
Definition for a binary tree node.
**/
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BSTIterator(root: TreeNode?) {
    var stack = mutableListOf<TreeNode>()

    init {
        inorder(root)
    }

    private fun inorder(node: TreeNode?) {
        if (node == null)
            return
        inorder(node.left)
        stack.add(node)
        inorder(node.right)
    }

    fun next(): Int {
        val i = stack.removeAt(0)
        return i.`val`

    }

    fun hasNext(): Boolean {
        return stack.size > 0
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */

fun main(){
    val root: TreeNode = TreeNode(7);
    for (i in intArrayOf(3, 15, 9, 20)){
        var node = root
        var hasSet = false
        while (!hasSet){
            if (node.`val` >= i){
                if (node.left != null)
                    node = node.left!!
                else {
                    node.left = TreeNode(i)
                    hasSet = true
                }
            }else {
                if (node.right != null)
                    node = node.right!!
                else {
                    node.right = TreeNode(i)
                    hasSet = true
                }
            }
        }
    }
    var obj = BSTIterator(root)
    println(obj.next())
    println(obj.next())
    println(obj.hasNext())
    println(obj.next())
    println(obj.hasNext())
    println(obj.next())
    println(obj.hasNext())
    println(obj.next())
    println(obj.hasNext())
}