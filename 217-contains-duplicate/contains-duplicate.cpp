class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        map<int, bool> f;
        for(auto num : nums) {
            if (f[num] != NULL) {
                return true;
            } else {
                f[num] = true;
            }
        }

        return false;
    }
};