class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        map_of_char = {i: [0] for i in range(ord('A'), ord('Z') + 1)}

        def getHighest(l,r):
            ans = 0
            for c in range(ord('A'), ord('Z')+1) :
                if map_of_char[c][r]-map_of_char[c][l] > ans:
                    ans = map_of_char[c][r]-map_of_char[c][l]
            return ans

        idx=1
        for c in s:
            for i in range(ord('A'), ord('Z')+1) :
                if c == chr(i):
                    map_of_char[i].append(1 + map_of_char[i][idx-1])
                else:
                    map_of_char[i].append(map_of_char[i][idx-1])
            idx+=1
            
        r = 1
        l = 0
        ans = 0
        while l <= len(s):
            highest = getHighest(l,r)

            if r-l <= highest+k and ans < r-l:
                ans = r-l

            if r-l <= highest+k and r+1 <= len(s):
                r+=1
            else:
                l+=1

        return ans