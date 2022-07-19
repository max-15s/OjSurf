// https://leetcode.com/problems/middle-of-the-linked-list/
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        var fCurrent = head
        var fCount = 0
        if (fCurrent == null)
            return head
        while (fCurrent != null) {
            fCount += 1
            fCurrent = fCurrent.next
        }
        var v = (fCount / 2)
        fCurrent = head
        for (i in 1 .. v){
            fCurrent = fCurrent?.next
        }
        return fCurrent
    }
}

fun main(){
    val v = ListNode(1)
    var c = v
    for (i in 2 .. 6){
        c.next = ListNode(i)
        c = c.next!!
    }
    val s = Solution()
    println(s.middleNode(v))
}