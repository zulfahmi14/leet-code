class Solution {

    // sliding windows -> non-incr and non-decr.
    // whenever it slides to the r -> non-incr--, also check non-decr check new data is keeping the non-decr or not, and 
    // 1 2 3 4 5 6 7 8 9 10 -> non incr
    // 1 2 3 4 5 6 7 8 9 10 -> non decr

    // loop check each idx 

    // 3 1 2 5 5 5 2 7
    // 0 1 0 0 1 2 3 0
    // 0 4 3 2 1 0 0

    public List<Integer> goodIndices(int[] nums, int k) {
        int[] nonIncr = new int[nums.length];
        int[] nonDecr = new int[nums.length];
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < nums.length ; i++) {
            if (i == 0) nonIncr[i] = 1;
            else {
                if (nums[i] <= nums[i-1]) {
                    nonIncr[i] = nonIncr[i-1]+1;
                } else {
                    nonIncr[i] = 1;
                }
            }
        }

        for(int i = nums.length-1; i >= 0 ; i--) {
            if (i == nums.length-1) nonDecr[i] = 1;
            else {
                if (nums[i] <= nums[i+1]) {
                    nonDecr[i] = nonDecr[i+1] + 1;
                } else {
                    nonDecr[i] = 1;
                }
            }
        }

        for(int i = k; i < nums.length - k ; i++) {
            // System.out.println("[" + i + "]" + "nonIncr = " + nonIncr[i] + ", nonDecr = " + nonDecr[i]);
            if (nonIncr[i-1] >= k && nonDecr[i+1] >= k) {
                ans.add(i);
            }
        }

        return ans;
    }
}