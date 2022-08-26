// https://leetcode.com/problems/add-binary/
class Solution {
    fun addBinary(a: String, b: String): String {
        if (a == "0")
            return b
        if (b == "0")
            return a
        val answer = IntArray(a.length + b.length) { 0 }
        val rnum1 = a.reversed()
        val rnum2 = b.reversed()

        for ( i in 0..rnum1.length + rnum2.length - 1){
            if (i < rnum1.length && i < rnum2.length){
                answer[i] += rnum1[i].toString().toInt() + rnum2[i].toString().toInt()
            }else if (i < rnum1.length && i >= rnum2.length){
                answer[i] += rnum1[i].toString().toInt()
            }else if (i >= rnum1.length && i < rnum2.length){
                answer[i] += rnum2[i].toString().toInt()
            }
            if (answer[i] == 2){
                answer[i] = 0
                answer[i+1] = 1
            } else if (answer[i] == 3){
                answer[i] = 1
                answer[i+1] = 1
            }
        }

        val res = answer.reversed().joinToString(separator="")
        var index = 0
        for (i in 0 .. res.length)
            if (res[i] != '0'){
                index = i
                break
            }
        return res.substring(index, res.length)
    }
}

fun main() {
    val s = Solution()
    print(s.addBinary("11", "1"))
}