class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> listStart = new HashMap<>();
        Map<Integer, Integer> listEnd = new HashMap<>();

        for(int i=0 ; i < intervals.length ; i++) {
            set.add(intervals[i][0]);
            set.add(intervals[i][1]);
            if (listStart.containsKey(intervals[i][0])) {
                listStart.put(intervals[i][0], listStart.get(intervals[i][0])+1);
            } else {
                listStart.put(intervals[i][0], 1);
            }

            if (listEnd.containsKey(intervals[i][1])) {
                listEnd.put(intervals[i][1], listEnd.get(intervals[i][1])+1);
            } else {
                listEnd.put(intervals[i][1], 1);
            }
        }


        List<Integer> listAll = new ArrayList<>(set);
        listAll.sort((a, b) -> a - b);

        int ans = 0;
        int rooms = 0;
        for(Integer time : listAll) {
            rooms += listStart.getOrDefault(time, 0);
            rooms -= listEnd.getOrDefault(time, 0);
            ans = Math.max(ans, rooms);
        }

        return ans;
    }
}