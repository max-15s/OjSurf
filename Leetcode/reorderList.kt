// https://leetcode.com/problems/reorder-list/
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun rotate(head: ListNode): ListNode? {
        if ( head.next == null)
            return head
        var cursor: ListNode = head.next!!
        while (cursor.next != null){
            cursor = cursor.next!!
        }
        val end = cursor
        cursor.next = head
        var cutPoint: ListNode = head
        while(cutPoint.next != end)
            cutPoint = cutPoint.next!!
        cutPoint.next = null
        return end
    }
    fun reorderList(head: ListNode?): Unit {
        var currentNode = head
        var cnt = 1
        while (currentNode != null) {
            cnt += 1
            if (cnt % 2 == 0 && currentNode.next != null)
                currentNode.next = rotate(currentNode.next!!)
            currentNode = currentNode.next
        }
    }
}

fun main(){
    val nums = intArrayOf(1,2,3,4,5)
    var head: ListNode? = ListNode(nums[0])
    var current = head
    for ( i in nums.slice(1 .. nums.size-1)){
        val c = ListNode(i)
        if (current != null) {
            current.next = c
        }
        if (current != null) {
            current = current.next!!
        }
    }
    val s = Solution()
    s.reorderList(head)
    while(head != null){
        println(head.`val`)
        head = head.next
    }
}