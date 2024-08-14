class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int total = 0;
        set<int> v;
        for(int i =0 ; i < nums.size() ; i ++) {
            total += nums[i];
        }

        if (total % 2 > 0 || nums.size() <= 1) {
            return false;
        }


        return dp(nums, v, total/2, nums.size()-1);
    }

    bool dp(vector<int>& nums, set<int>& v, int sum, int idx) {
        v.insert(0);
        set<int> v2;
        for(int i =0 ;i<nums.size(); i++) {
            v2 = v;
            for(auto s : v2) {
                if (s+nums[i] == sum) return true;
                v.insert(s+nums[i]);
                v.insert(s);
            }
        }

        return v.count(sum) > 0;
    }
};

// for each value in the array, need to consider take or leave