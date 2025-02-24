class Solution {
      private static void backtracking(Set<List<Integer>> ans, List<Integer> temp, int[] nums, boolean[] f) {

    if (temp.size() == nums.length) {
      ans.add(new ArrayList<>(temp));
      return;
    }

    for(int i=0; i < nums.length ; i++) {
      if(!f[i]) {
        temp.add(nums[i]);
        f[i] = true;
        backtracking(ans, temp, nums, f);

        // remove last record
        f[i] = false;
        temp.remove(temp.size()-1);
      }
    }
  }

  public static List<List<Integer>> permuteUnique(int[] nums) {
    Set<List<Integer>> ans = new HashSet<>();
    backtracking(ans, new ArrayList<>(), nums, new boolean[nums.length]);
    return new ArrayList<>(ans);
  }
}

// 1 2 3

