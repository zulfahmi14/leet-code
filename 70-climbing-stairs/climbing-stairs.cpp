class Solution {
public:

    int climbStairs(int n) {
        vector<int> v(50, -1);
        return dp(v, n);
    }

    int dp(vector<int>& v, int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (v[n] != -1) return v[n];
        v[n] = dp(v, n-1) + dp(v, n-2);
        return v[n];
    }
};