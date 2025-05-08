class Solution {

    private boolean fillData(Map<Integer, List<Integer>> map, boolean[] f, List<Integer> ans, int idx, Set<Integer> cyc) {
        if (f[idx]) {
            return true;
        }

        if (cyc.contains(idx)) {
            return false;
        }

        cyc.add(idx);
        boolean resp = true;
        for(Integer preq : map.get(idx)) {
            resp = resp & fillData(map, f, ans, preq, cyc);
        }

        ans.add(idx);
        f[idx] = true;
        return resp;
    }

    public int[] findOrder(int num, int[][] pre) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] f = new boolean[num];
        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i < num ; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int i = 0 ; i < pre.length ; i++) {
            map.get(pre[i][0]).add(pre[i][1]);
        }

        for(int i = 0 ; i< num;i++) {
            if (f[i] == false) {
                boolean temp = fillData(map, f, ans, i, new HashSet<>());
                if(temp == false) {
                    return new int[0];
                }
            }
        }

        return ans.size() == num ? ans.stream().mapToInt(Integer::intValue).toArray() : new int[0];
    }
}

// want A then take B first.
// want A then take C first.


// A --> B
//   --> C
// =======

// if i have B then i can take A.

// first collect all data that doesnt have any dependencies.

// B, C, -> can add A, if B and C is there!