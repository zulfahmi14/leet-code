class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int ans[] = new int[nums.length-k+1];

        for(int i = 0 ; i < nums.length ; i++) {
            // keep sliding windows = K
            if (!dq.isEmpty() && i >= k && dq.getFirst() < i-k+1) { // i = 1, k = 1.
                dq.removeFirst();
            }

            while (!dq.isEmpty() && nums[dq.getLast()] < nums[i]) {
                dq.removeLast();
            }

            dq.addLast(i);

            if (i >= k-1) {
                ans[i-k+1] = nums[dq.getFirst()];
            }
        }

        return ans;
    }
}