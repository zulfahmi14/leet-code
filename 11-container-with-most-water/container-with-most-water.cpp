class Solution {
public:
    int maxArea(vector<int>& height) {
        int l = 0;
        int r = height.size()-1;
        long ans = 0;
        while(l < r) {
            ans = max(ans, (long)((r-l)*min(height[l], height[r])));

            if (height[l] < height[r]) l++ ;
            else r--;
        }

        return ans;
    }
};