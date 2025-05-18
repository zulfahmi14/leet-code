class Solution {
    private class Pair {
        int count;
        String str;

        Pair(int count, String str) {
            this.count = count;
            this.str = str;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> m = new HashMap<>();

        wordList.add(beginWord);
        for(int i=0 ; i < wordList.size() ; i++) {
            for(int j = 0 ; j < wordList.get(i).length() ; j++) {
                String w;
                if (j == 0) w = "*" + wordList.get(i).substring(j+1);
                else if (j == wordList.get(i).length()-1) w = wordList.get(i).substring(0, j) + "*";
                else w = wordList.get(i).substring(0, j) + "*" + wordList.get(i).substring(j+1);
                m.computeIfAbsent(w, k -> new ArrayList<>()).add(wordList.get(i));
            }
        }

        Queue<Pair> q = new ArrayDeque<Pair>();
        Set<String> visited = new HashSet<>();
        int ans = 0;
        q.add(new Pair(1, beginWord));

        while(!q.isEmpty()) {
            Pair current = q.poll(); // get and remove.

            if(current.str.equals(endWord)) {
                ans = current.count;
                break;
            }

            if (visited.contains(current.str)) {
                continue;
            }

            visited.add(current.str);

            for(int j = 0 ; j < current.str.length() ; j++) {
                String w;
                if (j == 0) w = "*" + current.str.substring(j+1);
                else if (j == current.str.length()-1) w = current.str.substring(0, j) + "*";
                else w = current.str.substring(0, j) + "*" + current.str.substring(j+1);

                for(String s : m.getOrDefault(w, new ArrayList<>())) {
                    if (s != current.str && !visited.contains(s)) q.add(new Pair(current.count+1, s));
                }
            }
        }

        return ans;
    }
}