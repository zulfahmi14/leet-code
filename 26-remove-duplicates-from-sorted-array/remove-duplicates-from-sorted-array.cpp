class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int i = 0;
        int val = -10000;
        while(i < nums.size()) {
            if (nums[i] == val) {
                nums.erase(nums.begin() + i);
            } else {
                val = nums[i];
                i++;
            }
        }

        return nums.size();
    }
};