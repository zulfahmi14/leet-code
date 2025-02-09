class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> ans ;
        int b = -1,a = -1; // before, after.

        sort(intervals.begin(), intervals.end());

        for(int i=0; i<intervals.size() ; i++) {
            if (b == -1) b = i;
            if (a == -1) a = i;
            
            b = (intervals[b][0] < intervals[i][0])? b : i;
            a = (intervals[a][1] > intervals[i][1])? a : i;

            if (i+1 == intervals.size()) {
                ans.push_back({intervals[b][0], intervals[a][1]});
                break;
            }

            // split and push
            if (intervals[a][1] < intervals[i+1][0]) {
                ans.push_back({intervals[b][0], intervals[a][1]});
                b = -1;
                a = -1;
            }
        }

        return ans;
    }
};