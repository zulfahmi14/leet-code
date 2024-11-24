class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> count;
        vector<pair<int, int>> v;
        vector<int> ans;
        for(auto num : nums) {
            count[num]++;
        }

        for(auto x : count) {
            v.push_back({x.second, x.first});
        }

        sort(v.rbegin(), v.rend());

        for(int i =0 ;i < k && i < v.size(); i++) {
            ans.push_back(v[i].second);
        }

        return ans;
    }
};