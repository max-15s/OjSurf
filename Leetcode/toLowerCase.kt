// https://leetcode.com/problems/to-lower-case/
class Solution {
    fun toLowerCase(s: String): String {
        val res = mutableListOf<Char>()
        for (ch in s){
            if (ch in 'A'..'Z')
                res.add(ch + 32)
            else
                res.add(ch)

        }
        return String(res.toCharArray())

    }
}

fun main(){
    print(('a' - 'A').toInt())
}