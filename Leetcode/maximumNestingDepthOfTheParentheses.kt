// 1614 - https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
class Solution {
    fun maxDepth(s: String): Int {
        var depth = 0
        var maxDepth = 0
        for (c in s) {
            if (c == '(') {
                depth += 1
            }else if (c == ')'){
                depth -= 1
            }
            maxDepth = maxOf(depth, maxDepth)
        }
        return maxDepth
    }
}