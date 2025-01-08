class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int ans = 0;
        int total = 0;
        map<int, int> m;
        for(int x : nums) {
            m[x]++;
        }

        for(auto mm : m) {
            if (ans < mm.second) {
                ans = mm.second;
                total = mm.first;
            }
        }

        return total;
    }
};