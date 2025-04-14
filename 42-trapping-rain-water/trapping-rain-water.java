class Solution {
    public int trap(int[] height) {
        int[] leftH = new int[height.length];
        int[] rightH = new int[height.length];
        
        int maxHeight = height[0];
        for(int i = 0 ; i< height.length ; i++) {
            maxHeight = Math.max(maxHeight, height[i]);
            leftH[i] = maxHeight;
        }

        maxHeight = height[height.length-1];
        for(int i = height.length-1 ; i >= 0 ; i--) {
            maxHeight = Math.max(maxHeight, height[i]);
            rightH[i] = maxHeight;
        }

        int ans = 0;
        for(int i = 0 ; i< height.length ; i++) {
            ans +=  Math.max(Math.min(rightH[i], leftH[i]) - height[i], 0);
        }

        return ans;
    }
}