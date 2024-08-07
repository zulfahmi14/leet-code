class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        map<long, int> map ;
        for (int i = 0 ; i < nums.size() ; i++) {
            map[nums[i]+1000000001] =  1;
        }

        int maxAns = 0;
        int tempAns = 1;
        long prevVal = 0;

        for(auto &val : map) {
            if (val.first == prevVal+1) {
                tempAns++ ;
            } else {
                tempAns = 1;
            }

            maxAns = max(maxAns, tempAns);

            prevVal = val.first;
        }

        return maxAns ;
    }
};