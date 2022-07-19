import java.util.*

// https://leetcode.com/problems/n-ary-tree-preorder-traversal/

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}


class Solution {
    val visit = Stack<Node>()
    fun preorder(root: Node?): List<Int> {
        visit.push(root)
        val toReturn = mutableListOf<Int>()
        if (root == null)
            return toReturn.toList()
        while (!visit.isEmpty()){
            val n = visit.pop()
            toReturn.add(n.`val`)
            if (n.children != null){
                for (c in n.children.reversed())
                    visit.push(c)
            }
        }
        return toReturn.toList()
    }
}