class Solution {
    
    public int binser2(int[] nums, int val) {
        int l = 0;
        int r = nums.length-1;
        int ans = 1;

        while(l <= r) {
            int mid = (r+l)/2;
            if (nums[mid] == val) {
                return mid; // no more higher result.
            } else if (nums[mid] < val) {
                ans = mid+1;
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        
        return ans;
    }
    
    // 4,6 -> 2
    // 6
    
    // 5, 11, 1 -> 8
    // 

// 2 7 : 2
// 5 7 : 2
// 5 5 : 2
    
    
    public int binser(int[] nums, int l, int r, int target) {
        Set<Integer> avail = new HashSet<>();
        
        for(int i=0 ; i < nums.length ; i++) {
            avail.add(nums[i]);
        }
        
        while(l <= r) {
            int mid = (l + r)/2;
            int dataLeft = binser2(nums, mid);
            
            System.out.println(mid + " : " + dataLeft);
            
            if (mid-(nums[0]+dataLeft-1) == target && !avail.contains(mid)) {
                return mid;
            }
            
            if (mid-(nums[0]+dataLeft-1) <= target) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        
        return -1;
    }
    
    public int missingElement(int[] nums, int k) {
        return binser(nums, nums[0]+1, nums[nums.length-1]+k, k);
    }
}