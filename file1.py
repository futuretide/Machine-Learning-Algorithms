class Solution(object):
    def twoSum(self, nums, target):
        curr = nums_index[begin][0] + nums_index[end][0]
        if curr == target:
            return [nums_index[begin][1], nums_index[end][1]]
        elif curr < target:
            begin += 1
        else:
            end -= 1


if __name__ == '__main__':
    # begin
    s = Solution()
    print s.twoSum([3, 2, 4], 6)
