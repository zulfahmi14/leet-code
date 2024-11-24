class Solution:
    

    def isHappy(self, n: int) -> bool:
        def getSum(n):
            ans = 0
            for x in str(n):
                ans = ans + (int(x) ** 2)
            return ans

        s = set()
        while n != 1 and n not in s:
            s.add(n)
            n = getSum(n)
        return n == 1
        