// https://leetcode.com/problems/multiply-strings/

class Solution {
    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0")
            return "0"
        val answer = IntArray(num1.length + num2.length + 10) { 0 }
        val rnum1 = num1.reversed()
        val rnum2 = num2.reversed()

        for ( i in rnum1.indices){
            for ( j in rnum2.indices)
                answer[i+j] += rnum1[i].toString().toInt() * rnum2[j].toString().toInt()
            for (i in 0 .. answer.size - 2){
                if (answer[i] > 9) {
                    answer[i + 1] += (answer[i] / 10)
                    answer[i] %= 10
                }
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
    print(s.multiply("123", "456"))
}