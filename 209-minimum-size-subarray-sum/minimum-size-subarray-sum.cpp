class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        vector<int> sums;
        sums.push_back(0);
        for (int i=0; i<nums.size() ; i++) {
            sums.push_back(nums[i]+sums[sums.size()-1]);
        }

        int l = 0, r = 1;
        int ans = 0;
        while(l<r) {
            if (sums[r]-sums[l] >= target) {
                if (ans == 0 ) ans = r-l;
                else ans = min(r-l, ans);
            }

            if (sums[r]-sums[l] < target && r+1 < sums.size()) {
                r++;
            } else {
                l++;
            }
        }

        return ans;
    }
};