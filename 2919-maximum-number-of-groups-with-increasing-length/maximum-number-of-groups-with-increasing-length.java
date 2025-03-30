class Solution {
    private boolean satisfy(List<Integer> usageLimits, int group) {
        int h = group;
        int gap = 0;
        for(int i=0;i<usageLimits.size();i++) {
            // update gap.
            gap = Math.max(0, h-usageLimits.get(i)+gap);
            
            if (h>0) {
                h--;
            }
        }

        return gap == 0;
    }

    public int maxIncreasingGroups(List<Integer> usageLimits) {
        
        Collections.sort(usageLimits, (a,b) -> b-a); // descending.

        int l = 0, r = usageLimits.size();
        int ans = 0;

        while(l <= r) {
            int mid = (r+l)/2;

            if (satisfy(usageLimits, mid)) {
                ans = mid;
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        return ans;
    }
}