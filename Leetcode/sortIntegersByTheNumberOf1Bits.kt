// https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/

class ComparatorOne: Comparator<Int>{
    override fun compare(o1: Int?, o2: Int?): Int {
        var c1 = 0
        var c2 = 0
        if(o1 == null || o2 == null){
            return 0;
        }
        for (i in 0..31){
            if (o1 shr(i) and 1 == 1)
                c1 += 1
            if (o2 shr(i) and 1 == 1)
                c2 += 1

        }
        if (c1 != c2)
            return c1 - c2
        else
            return o1 - o2
    }
}

class Solution {
    fun sortByBits(arr: IntArray): IntArray {
        val comparator = ComparatorOne()
        return arr.sortedWith(comparator).toIntArray()
    }
}

fun main(){
    val s = Solution()
    for (i in s.sortByBits(intArrayOf(1024,512,256,128,64,32,16,8,4,2,1))){
        println(i)
    }
}