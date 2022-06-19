import java.util.*
import kotlin.collections.ArrayList

// https://leetcode.com/problems/trim-a-binary-search-tree/
class TreeNode(var `val`: Int) {
     var left: TreeNode? = null
     var right: TreeNode? = null
}

class Solution {
    fun trimBST(root: TreeNode?, low: Int, high: Int): TreeNode? {
        if (root == null) return null
//        if (root.left != null && root.left!!.`val` < low)
//            root.left = root.left!!.right
//        if (root.right != null && root.right!!.`val` > high)
//            root.right = root.right!!.left

        while (root.`val` < low || root.`val` > high){
            while (true){
                if (root.`val` < low){
                    if (root.right != null) {
                        root.`val` = root.right!!.`val`
                        root.left = root.right?.left
                        root.right = root.right?.right
                    } else return null
                } else break
            }

            while (true){
                if (root.`val` > high){
                    if (root.left != null) {
                        root.`val` = root.left!!.`val`
                        root.right = root.left?.right
                        root.left = root.left?.left
                    } else return null
                } else break
            }
            if (root == null) return null
        }

        root.left = trimBST(root.left, low, high)
        root.right = trimBST(root.right, low, high)
        return root
    }
}

fun mock(inputList: Array<Int?>): TreeNode? {
    val nums: Queue<TreeNode> = LinkedList<TreeNode>()
    var root: TreeNode? = null
    for ( i in inputList) {
        var courser = root
        if (i == null)
            continue
        if (root == null) {
            root = TreeNode(i)
            continue
        }
        while (courser != null) {
            if (courser != null && i >= courser.`val`) {
                if (courser.right == null) {
                    courser.right = TreeNode(i)
                    break
                } else
                    courser = courser.right
            } else if (courser != null) {
                if (courser.left == null) {
                    courser.left = TreeNode(i)
                    break
                } else
                    courser = courser.left
            }
        }
    }
    return root
}

fun main() {
    val s = Solution()
//    val t = TreeNode(1)
//    t.left = TreeNode(0)
//    t.right = TreeNode(2)
//    s.trimBST(t, 1,2)
//
//    val t1 = TreeNode(3)
//    s.trimBST(t1, 2, 2)

//    val t3 = mock(arrayOf(3,1,4,null,2))
//    s.trimBST(t3, 1, 2)
    val t3 = mock(arrayOf(18,0,40,null,2,22,49,1,17,21,32,45,null,null,null,9,null,19,null,29,37,44,47,8,13,null,20,26,30,33,39,42,null,46,48,3,null,10,16,null,null,24,27,null,31,null,35,38,null,41,43,null,null,null,null,null,4,null,12,14,null,23,25,null,28,null,null,34,36,null,null,null,null,null,null,null,7,11,null,null,15,null,null,null,null,null,null,null,null,null,null,5,null,null,null,null,null,null,6))
    val high = 35
    val low = 35
    s.trimBST(t3, low, high)
}