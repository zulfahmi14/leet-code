class Solution {
public:
    // int v[1001][1001] ;

    int longestCommonSubsequence(string text1, string text2) {
        vector<vector<int>> v(text1.length(), vector<int>(text2.length(), -1));
        // memset(v,-1,1001*1001*sizeof(int));
        return dp(text1, text2, v, 0, 0);
    }

    int dp(string& text1, string& text2, vector<vector<int>>& v, int idx1, int idx2) {
        if (idx1 >= text1.length() || idx2 >= text2.length()) return 0;
        if (v[idx1][idx2] != -1) return v[idx1][idx2];

        if (text1[idx1] == text2[idx2]) {
            v[idx1][idx2] = 1+dp(text1, text2, v, idx1+1, idx2+1);
        } else {
            v[idx1][idx2] = max(dp(text1, text2, v, idx1+1, idx2), dp(text1, text2, v, idx1, idx2+1));
        }

        return v[idx1][idx2];
    }
};