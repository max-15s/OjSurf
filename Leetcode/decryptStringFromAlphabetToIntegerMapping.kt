// https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
class Solution {
    val a = 'a' - 1
    val j = 'j' - 10
    fun convert(st: String): Char{
        """converts 10# to j"""
        return j + st.removeSuffix("#").toInt()
    }
    fun freqAlphabets(s: String): String {
        val p = """\d{2}#""".toRegex()
        val res = mutableListOf<Char>()
        var seq = p.find(s, 0)
        var charStart = 0
        while (seq != null){
            for (i in charStart until seq.range.first){
                res.add(a + s[i].toString().toInt())
            }
            res.add(convert(seq.value))
            charStart = seq.range.last + 1
            seq = p.find(s, charStart)
        }
        for (i in charStart until s.length){
            res.add(a + s[i].toString().toInt())
        }
        return String(res.toCharArray())
    }
}

fun main(){
    val s = Solution()
    println(s.freqAlphabets("10#11#12"))
    println(s.freqAlphabets("1326#"))
}