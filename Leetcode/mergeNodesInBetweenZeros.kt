// https://leetcode.com/problems/merge-nodes-in-between-zeros/


//Definition for singly-linked list.
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun mergeNodes(head: ListNode?): ListNode? {
        if (head == null)
            return null
        var curr = head
        var res: ListNode? = null
        var toReturn: ListNode? = null
        var flap = false
        while (curr != null){
            if (curr.`val` == 0) {
                flap = true
            } else{
                if (res == null){
                    res = ListNode(curr.`val`)
                    toReturn = res
                }else {
                    if (flap){
                        res.next = ListNode(curr.`val`)
                        res = res.next
                    } else {
                        res.`val` += curr.`val`
                    }
                }
                flap = false
            }
            curr = curr.next
        }
        return toReturn
    }
}


fun main() {
    val r = intArrayOf(0,3,1,0,4,5,2,0)
    val data = ListNode(r[0])
    var curr = data
    for (i in 1 until r.size){
        curr.next = ListNode(r[i])
        curr = curr.next!!
    }
    val s = Solution()
    print(s.mergeNodes(data))

}