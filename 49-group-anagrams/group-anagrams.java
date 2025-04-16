class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupStr = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for(int i=0 ; i < strs.length ; i++ ) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            groupStr.computeIfAbsent(sortedStr, (k) -> new ArrayList<>());
            groupStr.get(sortedStr).add(strs[i]);
        }

        for(List<String> val : groupStr.values()) {
            ans.add(val);
        }

        return ans;
    }
}