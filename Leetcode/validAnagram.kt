// https://leetcode.com/problems/valid-anagram/
class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val ts = String(s.toCharArray().sortedArray())
        val tt = String(t.toCharArray().sortedArray())
        return ts == tt
    }
}
