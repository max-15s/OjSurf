import java.util.*

// https://leetcode.com/problems/length-of-last-word/
class Solution {
    fun lengthOfLastWord(s: String): Int {
        val st = Stack<Char>()
        for (c in s){
            if (st.isEmpty())
                st.push(c)
            else if (c != ' ')
                st.push(c)
            else if (st.peek() != ' ')
                st.push(c)
        }
        if (!st.isEmpty() && st.peek() == ' ')
            st.pop()
        var cnt = 0
        while (!st.isEmpty() && st.peek() != ' '){
            st.pop()
            cnt += 1
        }
        return cnt
    }
}

fun main(){
    val s = Solution()
    print(s.lengthOfLastWord("   fly me   to   the moon  "))
}