class Solution {
    private class Data {
        public int startTime;
        public int endTime;
        public int profit;

        public Data(int start, int end, int profit) {
            this.startTime = start;
            this.endTime = end;
            this.profit = profit;
        }
    }

    private int LastEndTime(List<Data> dataList, int idx) {

        int r = idx-1;
        int l = 0;
        while(r >= l) {
            int mid = (r+l)/2;
            if (dataList.get(mid).endTime <= dataList.get(idx).startTime) {
                if (dataList.get(mid+1).endTime <= dataList.get(idx).startTime) {
                    l = mid+1;
                } else {
                    return mid;
                }
            } else {
                r = mid-1;
            }
        }

        return -1;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Data> dataList = new ArrayList<>();
        int dp[] = new int[startTime.length+1];
        for(int i = 0 ; i<startTime.length ; i++) {
            dataList.add(new Data(startTime[i], endTime[i], profit[i]));
        }
        Collections.sort(dataList, (a, b) -> a.endTime - b.endTime);

        dp[0] = dataList.get(0).profit;
        for(int i = 1 ; i < dataList.size() ; i++) {
            int currentBenefit = dataList.get(i).profit;
            int prevEndTime = LastEndTime(dataList, i);
            if (prevEndTime != -1) {
                currentBenefit += dp[prevEndTime];
            }

            dp[i] = Math.max(dp[i-1], currentBenefit);
        }

        return dp[dataList.size()-1];
    }
}