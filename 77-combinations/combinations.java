class Solution {

  private static void backtracking(Set<List<Integer>> ans, List<Integer> temp, int[] nums, int k, int s) {
    if (temp.size() == k) {
      ans.add(new ArrayList<>(temp));
      return;
    }

    for(int i=s; i < nums.length ; i++) {
        temp.add(nums[i]);
        backtracking(ans, temp, nums, k, i+1);

        // remove last record
        temp.remove(temp.size()-1);
    }
  }

  public static List<List<Integer>> combine(int n, int k) {
    int[] nums = new int[n];
    for(int i=1 ; i<= n ;i++) {
      nums[i-1] = i;
    }

    Set<List<Integer>> ans = new HashSet<>();
    backtracking(ans, new ArrayList<>(), nums, k, 0);
    return new ArrayList<>(ans);
  }
}