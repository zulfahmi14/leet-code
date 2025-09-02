class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> subArray = new ArrayDeque<>();
        int lengthAns = nums.length - k+1;
        int[] ans = new int[lengthAns];
        
        for(int i = 0 ; i < nums.length ; i++) {    
            // maintain the sliding windows size = k
            while(!subArray.isEmpty() && subArray.getLast() < i-k+1) {
                subArray.removeLast();
            }

            // maintain highest value.
            while(!subArray.isEmpty() && nums[subArray.getFirst()] <= nums[i]) {
                subArray.removeFirst();
            }

            subArray.addFirst(i);

            if (i >= k-1) {
                ans[i-k+1] = nums[subArray.getLast()];
            }
        }

        return ans;
    }
}

// 1 2 3 4 5

// i = 4
// k = 3
// last = 2