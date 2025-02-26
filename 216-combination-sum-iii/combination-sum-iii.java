class Solution {
      private static void backtracking(Set<List<Integer>> ans, List<Integer> temp, int[] nums, int k, int n, int s, int sumz) {
    if (temp.size() == k && n == sumz) {
      ans.add(new ArrayList<>(temp));
      return;
    } else if (temp.size() > k) {
      return;
    }

    for(int i=s; i < nums.length ; i++) {
        if (sumz+nums[i] <= n) {
          temp.add(nums[i]);
          backtracking(ans, temp, nums, k, n, i+1, sumz+nums[i]);

          // remove last record
          temp.remove(temp.size()-1);
        }
    }
  }

  public static List<List<Integer>> combinationSum3(int k, int n) {
    int[] nums = new int[9];
    for(int i=1 ; i<= 9 ;i++) {
      nums[i-1] = i;
    }

    Set<List<Integer>> ans = new HashSet<>();
    backtracking(ans, new ArrayList<>(), nums, k, n, 0, 0);
    return new ArrayList<>(ans);
  }
}