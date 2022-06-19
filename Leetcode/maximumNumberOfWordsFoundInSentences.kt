// https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/

class Solution {
    fun mostWordsFound(sentences: Array<String>): Int {
        val whiteSpaces = "\\b\\w+\\b".toRegex()
        var maxWords = Int.MIN_VALUE
        for (st in sentences){
            val wc = whiteSpaces.findAll(st).count()
            if (wc > maxWords)
                maxWords = wc
        }
        return maxWords
    }
}
