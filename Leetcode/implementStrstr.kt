// https://leetcode.com/problems/implement-strstr/
class Solution {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty())
            return 0
        if (needle.length > haystack.length)
            return -1


        for ( i in 0..haystack.length - needle.length ){
            var fit = true
            for (j in needle.indices){
                fit = fit && needle[j] == haystack[i+j]
            }
            if (fit)
                return i
        }
        return -1
    }
}