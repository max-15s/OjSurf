// https://leetcode.com/problems/plus-one/
class Solution {
    fun plusOne(digits: IntArray): IntArray {
        val a = mutableListOf<Int>()
        var carry = 0
        digits[digits.lastIndex] = digits[digits.lastIndex] + 1
        for (i in digits.lastIndex downTo 0){
            val t = carry + digits[i]
            if ( t > 9){
                a.add( t % 10 )
                carry =  t / 10
            }else {
                a.add(t)
                carry = 0
            }
        }
        if (carry != 0)
            a.add(carry)
        a.reverse()
        return a.toIntArray()
    }
}

fun main() {
    val s = Solution()
    for (c in s.plusOne(intArrayOf(1,3,9))){
        print(c)
    }
}