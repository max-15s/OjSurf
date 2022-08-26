import java.util.*
import java.util.Stack

// https://leetcode.com/problems/evaluate-reverse-polish-notation/
class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val s = Stack<Int>()
        val operators = arrayOf("+", "-", "*", "/")
        for (c in tokens) {
            if (operators.contains(c)) {
                val b = s.pop()
                val a = s.pop()
                if (c == "+")
                    s.push(a + b)
                else if (c == "-")
                    s.push(a - b)
                else if (c == "*")
                    s.push(a * b)
                else if (c == "/")
                    s.push(a / b)
            } else {
                s.push(c.toInt())
            }
        }
        return s.pop()
    }
}

fun main() {
    val s = Solution()
    println(s.evalRPN(arrayOf("4","13","5","/","+")))
}
