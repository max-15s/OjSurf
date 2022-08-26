import java.util.*

// https://leetcode.com/problems/linked-list-in-binary-tree/


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    val s = Stack<TreeNode>()

    fun checker(head: ListNode?, root: TreeNode?): Boolean {
        if (head == null){
            return true
        }
        if (root == null){
            return false
        }
        if (root.`val` == head.`val`){
            val l = checker(head.next, root.left)
            val r = checker(head.next, root.right)
            return l || r
        }else {
            return false
        }

    }

    fun isSubPath(head: ListNode?, root: TreeNode?): Boolean {
        s.push(root)
        while (!s.isEmpty()){
            val _p = s.pop()
            val v = checker(head, _p)
            if (v)
                return true
            if (_p.left != null)
                s.push(_p.left)
            if (_p.right != null)
                s.push(_p.right)
        }
        return false
    }
}