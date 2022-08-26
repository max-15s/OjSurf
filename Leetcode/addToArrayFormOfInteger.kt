// https://leetcode.com/problems/add-to-array-form-of-integer/

class Solution {
    fun addToArrayForm(num: IntArray, k: Int): List<Int> {
        val rk = k.toString()
        val answer = IntArray(num.size + rk.length + 1) { 0 }
        val rnum1 = num.reversed()
        val rnum2 = rk.reversed()

        for ( i in 0..rnum1.size + rnum2.length - 1){
            if (i < rnum1.size && i < rnum2.length){
                answer[i] += rnum1[i] + rnum2[i].toString().toInt()
            }else if (i < rnum1.size && i >= rnum2.length){
                answer[i] += rnum1[i]
            }else if (i >= rnum1.size && i < rnum2.length){
                answer[i] += rnum2[i].toString().toInt()
            }
            answer[i+1] += answer[i] / 10
            answer[i] = answer[i] % 10
        }

        val res = answer.reversed()
        var index = res.size - 1
        for (i in 0 until res.size)
            try{
                if (res[i] != 0){
                    index = i
                    break
                }
            }catch (e: IndexOutOfBoundsException) {
                index = res.size - 2
            }
        return res.slice(index until res.size)

    }
}


fun main(){
    val s = Solution()
    for (i in s.addToArrayForm(intArrayOf(0), 3))
        print(i)
}