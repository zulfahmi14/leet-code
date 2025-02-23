class Solution {
    public String largestNumber(int[] nums) {
            List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().toList());
    list.sort((a, b) -> (b.toString() + a.toString()).compareTo(a.toString() + b.toString()));

    if (list.getFirst() == 0) {
      return "0";
    }

    String ans = "" ;

    for(Integer i : list) {
      ans += i.toString();
    }

    return ans;
    }
}