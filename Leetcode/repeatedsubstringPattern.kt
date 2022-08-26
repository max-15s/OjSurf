// https://leetcode.com/problems/repeated-substring-pattern/
class Solution {
    fun repeatedSubstringPattern(s: String): Boolean {
        for (times in 0..s.length/2){
            val pattern = s.slice(0..times)
            var flag: Boolean? = null
            for ( j in 0..s.length-pattern.length step pattern.length){
                if (j == 0)
                    continue
                else {
                    if (flag == null)
                        flag = pattern == s.slice(j until j+pattern.length)
                    else
                        flag = flag && pattern == s.slice(j until j+pattern.length)
                }
            }
            if (flag != null && flag && s.length % pattern.length == 0)
                return true
        }
        return false
    }
}
fun main(){
    val s = Solution()
    println(s.repeatedSubstringPattern("aabaaba"))
    println(s.repeatedSubstringPattern("abac"))
    println(s.repeatedSubstringPattern("abab"))
    println(s.repeatedSubstringPattern("aba"))
    println(s.repeatedSubstringPattern("abcabcabcabc"))
    println(s.repeatedSubstringPattern("bb"))
}
