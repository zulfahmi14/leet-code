class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        set<vector<int>> ans;
        sort(candidates.begin(), candidates.end());
        vector<int> temp;
        search(candidates, 0, target, temp, ans);
        return vector<vector<int>> (ans.begin(), ans.end());
    }

    void search(vector<int>& candidates, int idx, int target, vector<int>& v, set<vector<int>>& ans) {
        if (target < 0) return;

        if(target == 0) {
            ans.insert(v);
            return ;
        }

        if (target > 0) {
            for(int i=idx ; i < candidates.size(); i++) {
                if (candidates[i] > target) {
                    break;
                }
                if (i > idx && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                v.push_back(candidates[i]);
                search(candidates, i+1, target-candidates[i], v, ans);
                v.pop_back();
            }
        }
    }
};