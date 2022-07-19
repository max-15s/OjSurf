import java.io.File.separator

// https://leetcode.com/problems/merge-strings-alternately/
class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        val result = CharArray(word1.length + word2.length)
        var head1 = 0
        var head2 = 0
        var cnt = 0
        var pos = 0
        while (head1 < word1.length || head2 < word2.length){
            if (cnt % 2 == 0){
                if (head1 < word1.length){
                    result[pos] = word1[head1]
                    pos += 1
                    head1 += 1
                }
            }else{
                if (head2 < word2.length){
                    result[pos] = word2[head2]
                    pos += 1
                    head2 += 1
                }
            }
            cnt += 1
        }
    return String(result)
    }
}