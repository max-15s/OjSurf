# 14 - https://leetcode.com/problems/longest-common-prefix/description/
class Solution(object):
    def longestCommonPrefix(self, strs):
        index = 0
        last_char = None
        max_index = min([len(s) for s in strs])
        for i in range(max_index):
            flag = False
            last_char = strs[0][index]
            for s in strs:
                if s[index] != last_char:
                    flag = True
                    break
            if flag:
                break
            else:
                index += 1
        return strs[0][:index]
