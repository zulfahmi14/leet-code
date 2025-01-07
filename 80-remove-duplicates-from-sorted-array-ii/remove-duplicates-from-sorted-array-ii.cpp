class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int i = 0;
        int val = -999999;
        int f = 0;
        while(i < nums.size()) {
            if (nums[i] == val) {
                if (f >= 1) {
                    nums.erase(nums.begin() + i);
                } else {
                    i++;
                    f++;
                }
            } else {
                val = nums[i];
                f = 0;
                i++;
            }
        }

        return i;
    }
};