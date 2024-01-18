// https://leetcode.com/problems/design-linked-list/

class Node(var `val`: Int) {
    var next: Node? = null
    var prev: Node? = null
}

class MyLinkedList() {
    var head: Node? = null

    fun get(index: Int): Int {
        var current = head
        var cnt = 0
        while(current != null)
            if (cnt == index)
                return current.`val`
            else {
                current = current.next
                cnt += 1
            }
        return -1
    }

    fun addAtHead(`val`: Int) {
        val tmp = Node(`val`)
        tmp.next = head
        head = tmp
    }

    fun addAtTail(`val`: Int) {
        val tmp = Node(`val`)
        if (head == null){
            head = tmp
            return
        }
        var current = head
        while(current?.next != null)
            current = current.next
        current?.next = tmp
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if (index == 0) {
            addAtHead(`val`)
            return
        }
        val tmp = Node(`val`)
        var cnt = 0
        var current = head
        while(current != null)
            if (cnt == index - 1){
                tmp.next = current.next
                current.next = tmp
                return
            } else {
                current = current.next
                cnt += 1
            }
    }

    fun deleteAtIndex(index: Int) {
        if (index == 0) {
            head = head?.next
            return
        }
        var cnt = 0
        var current = head
        while(current != null)
            if (cnt == index - 1){
                current.next = current.next?.next
                return
            } else {
                current = current.next
                cnt += 1
            }
    }

}

fun main(){
    var obj = MyLinkedList()
    println(obj.addAtHead(1))
    println(obj.addAtTail(3))
    println(obj.addAtIndex(1,2))
    println(obj.get(1))
    println(obj.deleteAtIndex(1))
    println(obj.get(1))
    println(obj.get(3))
    println(obj.deleteAtIndex(3))
    println(obj.deleteAtIndex(0))
    println(obj.get(0))
    println(obj.deleteAtIndex(0))
    println(obj.get(0))


}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(`val`)
 * obj.addAtTail(`val`)
 * obj.addAtIndex(index,`val`)
 * obj.deleteAtIndex(index)
 */