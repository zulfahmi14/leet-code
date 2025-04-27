class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for(int i = 0;i< nums.length ; i++) {
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if (minHeap.size() == this.k && val > minHeap.peek()) {
            minHeap.remove();
            minHeap.add(val);
        } else if (minHeap.size() < this.k) {
            minHeap.add(val);
        }

        return (minHeap.size() < k) ? -1 : minHeap.peek();
    }
}

// 1,2,3 -> 

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

 