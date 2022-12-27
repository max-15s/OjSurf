// https://leetcode.com/problems/group-anagrams/
class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val valve = HashMap<String, MutableList<String>>()
        for (s in strs){
            val ss = String(s.toCharArray().sorted().toCharArray())
            val t = valve.get(ss)
            if (t == null)
                valve[ss] = mutableListOf(s)
            else
                valve[ss]?.add(s)
        }
        val toReturn = mutableListOf<MutableList<String>>()
        for (k in valve.values)
            toReturn.add(k)
        return toReturn
    }
}

fun main(){
    val s = Solution()
    val t = s.groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat"))
    println()
}