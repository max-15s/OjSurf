// https://leetcode.com/problems/next-greater-element-iii/
class Solution {
    private fun genNumber(num: MutableList<Int>): Int {
        var l:Long = 0
        for (i in num){
            l = l * 10 + i
        }
        return if (l > Int.MAX_VALUE)
            -1
        else
            l.toInt()
    }

    fun nextGreaterElement(n: Int): Int {
        val num = mutableListOf<Int>()
        var t = n
        while (t > 9){
            num.add(t % 10)
            t /= 10
        }
        num.add(t)
        num.reverse()
        var index = -1
        val rightSide = mutableListOf<Int>()
        for (u in num.size - 1 downTo 0){
            rightSide.sort()
            for ((k, n) in rightSide.withIndex()){
                if (n > num[u]){
                    index = u
                    rightSide.removeAt(k)
                    rightSide.add(num[u])
                    num[u] = n
                    break
                }
            }
            if (index != -1)
                break
            else
                rightSide.add(num[u])
        }
        if (index == -1)
            return -1

        val left = num.slice(0 until index + 1)
        rightSide.sort()
        return genNumber((left + rightSide) as MutableList<Int>)
    }
}

fun main(){
    val s = Solution()
    println(s.nextGreaterElement(2147483476))
                                                 // 2147483476
                                                  //2147483647
                                                 // 2147483746
    println(s.nextGreaterElement(230241))  //230412
    println(s.nextGreaterElement(12))
    println(s.nextGreaterElement(987654321))
}