class Solution {
public:
    int trap(vector<int>& height) {
        long sum = 0;
        int len = height.size();

        int arrLeft[len];
        int arrRight[len];

        int maxL = 0;
        int maxR = 0;

        // potential water
        for(int i=0 ; i < len ;i++) {
            arrLeft[i] = maxL;
            
            if (maxL < height[i]) {
                maxL = height[i];
            }
        }

        // potential water from right
        for(int i=len-1 ; i >= 0 ;i--) {
            arrRight[i] = maxR;
            
            if (maxR < height[i]) {
                maxR = height[i];
            }
        }

        // calculate
        for(int i=0 ;i < len ; i++) {
            sum += max(min(arrLeft[i], arrRight[i]) - height[i], 0);
        }

        return sum;
    }
};