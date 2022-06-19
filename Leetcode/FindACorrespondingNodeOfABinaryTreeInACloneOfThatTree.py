# https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque


class Solution:
    def getTargetCopy(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
        q = deque()
        # traverse
        q.appendleft(
                (original, cloned,)
        )
        while len(q):
            popped = q.pop()
            if target.val == popped[0].val:
                return popped[1]
            else:
                if popped[0].left:
                    q.appendleft(
                            (popped[0].left, popped[1].left,)
                    )
                if popped[0].right:
                    q.appendleft(
                            (popped[0].right, popped[1].right,)
                    )
