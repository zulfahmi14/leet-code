class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        set<vector<int>> ans ;
        sort(nums.begin(), nums.end());
        for(int i =0 ; i < nums.size() - 2 ; i++) {
            
            if (nums[i] > 0) break ;

            // case triple 0
            if (nums[i] == 0 && nums[i+1] == 0 && nums[i+2] == 0) {
                ans.insert({0,0,0});
                break ;
            }

            if (nums[i] == nums[i+2]) continue;

            int l = i+1;
            int r = nums.size() -1 ;

            while(l < r) {
                if (nums[i]+nums[l]+nums[r] == 0) {
                    ans.insert({nums[i], nums[l], nums[r]});
                    l++;
                    r--;
                    continue;
                } else if(nums[i]+nums[l]+nums[r] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return vector<vector<int>> (ans.begin(), ans.end());
        // return vc;
    }
};