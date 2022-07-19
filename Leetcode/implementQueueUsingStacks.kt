import java.util.*

// https://leetcode.com/problems/implement-queue-using-stacks/
class MyQueue() {
    val s1 = Stack<Int>()
    val tmp = Stack<Int>()
    fun push(x: Int) {
        while (!s1.isEmpty())
            tmp.push(s1.pop())
        tmp.push(x)
        while (!tmp.isEmpty())
            s1.push(tmp.pop())
    }

    fun pop(): Int {
        return s1.pop()
    }

    fun peek(): Int {
        return s1.peek()
    }

    fun empty(): Boolean {
        return s1.isEmpty()
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */