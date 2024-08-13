class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& g) {
        vector<vector<int>> dp(g.size(), vector<int>(g[0].size(), 0));

        for(int i=0;i<g.size();i++) {
            for(int j=0;j<g[0].size();j++) {
                if(g[i][j] == 0) {
                    if(i == 0 && j == 0) {
                        dp[i][j] = 1;
                    } else if (i==0){
                        dp[i][j] = dp[i][j-1];
                    } else if(j==0) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
                else
                    dp[i][j] = 0;
            }
        }

        return dp[g.size()-1][g[0].size()-1];
    }
};