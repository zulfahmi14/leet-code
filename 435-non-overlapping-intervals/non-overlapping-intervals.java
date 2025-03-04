class Solution {
    public static int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a,b) -> {
      return Integer.compare(a[1], b[1]);
    });

System.out.println(intervals[0][0] + " " + intervals[0][1]);
    int remove = 0;
    int hVal = intervals[0][1];
    for(int i = 1 ; i < intervals.length ; i++) {
      if (intervals[i][0] < hVal) {
        remove++; continue;
      }
      hVal = Math.max(hVal, intervals[i][1]);
    }

    return remove;
  }
}