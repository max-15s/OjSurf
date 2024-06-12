// 1669 - https://leetcode.com/problems/merge-in-between-linked-lists/

 class ListNode(var `val`: Int) {
     var next: ListNode? = null
 }

class Solution {
    fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
        if (list2 == null) return list1
        if (list1 == null) return list2
        var cnt = 0
        var curr = list1
        while (cnt < a - 1 && curr != null) {
            cnt += 1
            curr = curr.next
        }
        var tmp = curr?.next
        curr?.next = list2
        curr = tmp
        var curr2 = list2
        while (curr2?.next != null) {
            curr2 = curr2.next
        }
        while (cnt < b - 1) {
            curr = curr?.next
            cnt += 1
        }
        curr2?.next = curr?.next
        return list1
    }
}

fun genList(A: IntArray): ListNode {
    val root = ListNode(A[0])
    var curr = root
    for (i in 1 .. A.size - 1) {
        curr.next = ListNode(A[i])
        curr = curr.next!!
    }
    return root
}

fun main() {
    val l1 = genList(intArrayOf(10,1,13,6,9,5))
    val l2 = genList(intArrayOf(1000000,1000001,1000002))
    val l3 = genList(intArrayOf(0,1,2,3,4,5,6))
    val l4 = genList(intArrayOf(1000000,1000001,1000002,1000003,1000004))
}