class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = [-1] * n

        stack = deque()
        stack.append(0)

        for i in range(1 , len(nums) * 2):
            ele = nums[i % n]

            while len(stack) > 0 and ele > nums[stack[-1]]:
                ans[stack[-1]] = ele
                stack.pop()

            if i < n:
                stack.append(i)

        return ans
        