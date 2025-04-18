class Solution {

    // [2,3], [3,4], []
    // [2,4], [1,3], []
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();

        int l = -1;
        int r = -1;
        for(int i = 0 ; i < intervals.length; i++) {
            if (l == -1) {
                l = intervals[i][0];
                r = intervals[i][1];
            } else {
                if (intervals[i][0] <= r) {
                    r = Math.max(intervals[i][1], r);
                } else {
                    ans.add(new int[]{l,r});
                    l = intervals[i][0];
                    r = intervals[i][1];
                }
            }

            if (i == intervals.length-1) {
                ans.add(new int[]{l,r});
            }
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}