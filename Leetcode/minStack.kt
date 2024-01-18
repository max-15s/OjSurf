import java.util.*

// https://leetcode.com/problems/min-stack/

class MinStack() {
    inner class minItem(`val`: Int, currentMin: Int){
        val value = `val`
        val currentMin = currentMin
    }
    val stack = Stack<minItem>()

    fun push(`val`: Int) {
        if ( stack.isEmpty() )
            stack.push(minItem(`val`, `val`))
        else{
            if (stack.peek().currentMin < `val`)
                stack.push(minItem(`val`, stack.peek().currentMin))
            else
                stack.push(minItem(`val`, `val`))
        }

    }

    fun pop() {
        stack.pop()
    }

    fun top(): Int {
        return stack.peek().value
    }

    fun getMin(): Int {
        return stack.peek().currentMin
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */