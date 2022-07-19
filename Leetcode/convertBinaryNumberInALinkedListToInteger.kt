// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun getDecimalValue(head: ListNode?): Int {
        if (head == null)
            return 0
        var curr = head
        var toReturn = 0
        while (curr != null){
            toReturn = toReturn shl (1) or curr.`val`
            curr = curr.next
        }
        return toReturn

    }
}

fun main(){
    val n = ListNode(1)
    n.next = ListNode(0)
    val p = n.next
    p?.next = ListNode(1)
    val s = Solution()
    println(s.getDecimalValue(n))
}
