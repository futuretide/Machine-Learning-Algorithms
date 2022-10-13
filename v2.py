class Solution:
	def trap(self, height: List[int]) -> int:

		length = len(height)

		left = [0] * length
		right = [0] * length

		left[0] = height[0]
		right[-1] = height[-1]
		
		start = 0
		while start < length:
			left[start] = max(left[start - 1], height[start])
			start = start + 1

		end = length - 2
		while end > -1:
			right[end] = max(right[end + 1], height[end])
			end = end - 1

		result = 0

		for index in range(length):
			result = result + min(left[index], right[index]) - height[index]

		return result

		
