class Solution {
    private class Trie {
        public Trie[] leaf = new Trie[26];
        public boolean endWord;

        public Trie() {}
    }

    public boolean dp(Trie root, char[] ch, boolean[] f, int idx) {
        Trie node = root;
        if (idx >= ch.length) {
            return true;
        }

        for(int i = idx ; i < ch.length ; i++) {
            if (node.leaf[ch[i]-'a'] == null) {
                return false;
            }

            if (node.leaf[ch[i]-'a'].endWord && f[i] != true) {
                if (i == ch.length-1) {
                    return true;
                }

                boolean result = dp(root, ch, f, i+1);
                if(result) {
                    return true;
                }

                f[i] = true;
            }

            node = node.leaf[ch[i]-'a'];
        }

        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        // Trie
        Trie root = new Trie();
        for(int i =0 ; i < wordDict.size() ; i++) {
            Trie process = root;
            char[] ch = wordDict.get(i).toCharArray();
            for(int j = 0 ; j < ch.length ; j++) {
                if (process.leaf[ch[j]-'a'] == null) {
                    process.leaf[ch[j]-'a'] = new Trie();
                }

                if (j == ch.length -1) {
                    process.leaf[ch[j]-'a'].endWord = true;
                }

                process = process.leaf[ch[j]-'a'];
            }
        }

        // DP
        int n = s.length();
        boolean[] f = new boolean[n];
        char[] ch = s.toCharArray();
        return dp(root, ch, f, 0);
    }
}