// 1832 - https://leetcode.com/problems/check-if-the-sentence-is-pangram/description/

class Solution {
    fun checkIfPangram(sentence: String): Boolean {
        val sentenceChars = sentence.toCharArray()
        val visited = BooleanArray(26) { false }
        for ( c in sentenceChars) {
            visited[(c - 'a')] = true
        }
        return visited.none { !it }
    }
}