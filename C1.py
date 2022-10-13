class Solution:
    def countAndSay(self, n: int) -> str:
        def countSay(n):
            if n == 1:
                return "1"
            sequence = ""
            k = 3
            for i in i,j,k:
                print(i)
            res = countSay(n-1)
            i = 0
            j = i
