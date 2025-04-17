class Solution {
    private class Data {
        public int left;
        public int right;

        public Data(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Map<Data, Boolean> f = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();
        List<Integer> numList = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        if(nums[0] > 0) {
            return new ArrayList<>(new ArrayList<>());
        }

        for(int i = 0 ; i< nums.length ; i++) {
            counts.computeIfAbsent(nums[i], (k) -> 0);
            if (counts.get(nums[i]) == 0) {
                numList.add(nums[i]);
            }
            counts.put(nums[i], counts.get(nums[i])+1);
        }

        for(int i = 0 ; i < numList.size() ; i++) {
            if (numList.get(i) > 0) break;

            for(int j = i ; j < numList.size() ; j++) {
                int c = numList.get(i) + numList.get(j);
                if (c > 0) break;

                c = c * -1;

                if (f.getOrDefault(new Data(numList.get(i), numList.get(j)), false) || c < numList.get(j) || (i == j && counts.get(numList.get(i)) < 2)) continue;

                if (counts.getOrDefault(c, 0) > 0) {
                    if (c == numList.get(j) && c == numList.get(i) && counts.get(c) >= 3) {
                        ans.add(new ArrayList(Arrays.asList(numList.get(i), numList.get(j), c)));
                        f.put(new Data(numList.get(i), numList.get(j)), true);
                    } else if (c == numList.get(j) && c != numList.get(i) && counts.get(c) >= 2) {
                        ans.add(new ArrayList(Arrays.asList(numList.get(i), numList.get(j), c)));
                        f.put(new Data(numList.get(i), numList.get(j)), true);
                    } else if (c != numList.get(j) && c != numList.get(i) && counts.get(c) >= 1) {
                        ans.add(new ArrayList(Arrays.asList(numList.get(i), numList.get(j), c)));
                        f.put(new Data(numList.get(i), numList.get(j)), true);
                    }
                }
            }
        }

        return ans;
    }
}