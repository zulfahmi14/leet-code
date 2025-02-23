class Solution {
    public void wiggleSort(int[] nums) {
    Arrays.sort(nums);
    List<Integer> list = Arrays.stream(nums).boxed().toList();

    int mid = nums.length-1;
    int minx = (nums.length%2==0? (nums.length/2) : (nums.length/2)+1)-1;
    for(int i = 0; i<nums.length; i++) {
      if (i%2==0) {
        nums[i] = list.get(minx);
        minx--;
      } else {
        nums[i] = list.get(mid);
        mid--;
      }
    }
    }
}