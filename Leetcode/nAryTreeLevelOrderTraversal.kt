import java.util.Queue
import java.util.LinkedList
// https://leetcode.com/problems/n-ary-tree-level-order-traversal/
class Node(var `val`: Int) {
 var children: List<Node?> = listOf()
}

class Solution {
    fun levelOrder(root: Node?): List<List<Int>> {
        val visit: Queue<Pair<Int, Node>> = LinkedList<Pair<Int, Node>>()
        val toReturn = mutableListOf<MutableList<Int>>()
        if (root == null)
            return toReturn
        visit.add(Pair(0, root))
        while (!visit.isEmpty()){
            val (l, v) = visit.poll()
            while (toReturn.size - 1 < l)
                toReturn.add(mutableListOf())
            toReturn[l].add(v.`val`)
            if (v.children != null)
                for (c in v.children)
                    visit.add(Pair(l+1, c) as Pair<Int, Node>?)
        }
        return toReturn
    }
}