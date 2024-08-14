class Solution {

public:
    
    int dp(vector<int>& nums, vector<int>& v, int idx) {
        if (idx == 0 ) return 0;
        if (idx == 1 ) return nums[0];
        if (idx == 2 ) return max(nums[0], nums[1]);
        if (v[idx] != -1) return v[idx];

        v[idx] = max(dp(nums, v, idx-1), nums[idx-1] + dp(nums, v, idx-2));

        return v[idx];
    }

    int rob(vector<int>& nums) {
        vector<int> v(101, -1);
        return dp(nums, v, nums.size());
    }
};


// len = 1 -> pick!
// len = 2 -> max(nums[2], nums[1]);
// len = 3 -> max(nums[3]+ nums[1], nums[2]);