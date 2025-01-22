class Solution {
public:
    int hIndex(vector<int>& citations) {
        int ans = 0;
        sort(citations.begin(), citations.end(),  greater<>());

        for(int i = 0 ; i<citations.size() ; i++) {
            if (citations[i] >= i) {
                ans = min(i+1,citations[i]);
            }
        }

        return ans;
    }
};