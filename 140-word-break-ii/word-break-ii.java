class Solution {
    
    Map<Integer, Map<Integer, String>> map = new HashMap<>(); 
    List<String> ans = new ArrayList<>();
    private void backTrack(String s, Set<String> set, Set<Integer> strlen, int idx) {

        for(Integer len : strlen) {
            if (idx+len > s.length()) {
                continue;
            }

            if (set.contains(s.substring(idx, idx+len))) {
                map.computeIfAbsent(idx, key -> new HashMap<>()).put(idx+len, s.substring(idx, idx+len));
                backTrack(s, set, strlen, idx+len);
            }
        }
    }

    private void generateAns(int idx, String actual, String substr) {
        if (map.get(idx) == null) return;

        for(Map.Entry<Integer, String> entry : map.get(idx).entrySet()) {
            String newVal = "";
            if (substr.length() == 0) {
                newVal = entry.getValue();
            } else {
                newVal = String.format("%s %s", substr, entry.getValue());
            }

            if (entry.getKey() == actual.length()) {
                ans.add(newVal);
                continue;
            }

            generateAns(entry.getKey(), actual, newVal);
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Set<Integer> strlen = wordDict.stream().map(ss -> ss.length()).collect(Collectors.toSet());
        backTrack(s, set, strlen, 0);
        System.out.println(map);

        generateAns(0, s, "");

        return ans;
    }
}