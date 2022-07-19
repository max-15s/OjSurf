// https://leetcode.com/problems/goal-parser-interpretation/
class Solution {
    fun interpret(command: String): String {
        var res = command.replace("(al)", "al")
        return res.replace("()", "o")
    }
}


fun main(){
    val s = Solution()
    print(s.interpret("(al)G(al)()()G"))
}