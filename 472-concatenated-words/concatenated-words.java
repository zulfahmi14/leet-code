class Solution {
    private class Trie {
        public boolean endWord;
        public Trie[] child = new Trie[26];

        public Trie() {}
        public Trie(boolean endWord) {
            this.endWord = endWord;
        }
    }

    public boolean matchStr(Trie root, String str, int idx, boolean f[]) {
        char[] word = str.toCharArray();
        if(idx >= word.length || root == null || f[idx]) return false;

        Trie trie = root;
        for(int i = idx ; i < word.length ; i++) {
            if(trie.child[word[i]-'a'] == null) {
                f[idx] = true;
                return false;
            }

            if(word.length == i+1 && trie.child[word[i]-'a'].endWord && idx != 0) {
                return true;
            }

            if(trie.child[word[i]-'a'].endWord) {
                boolean result = matchStr(root, str, i+1, f);

                if (result) {
                    return result;
                }
            }

            trie = trie.child[word[i]-'a'];
        }

        f[idx] = true;
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie root = new Trie();
        for(int i=0 ; i < words.length ; i++) {
            char chars[] = words[i].toCharArray();
            Trie tempTrie = root;
            for(int j =0 ; j < chars.length ; j++) {
                if (tempTrie.child[chars[j]-'a'] == null) {
                    tempTrie.child[chars[j]-'a'] = new Trie();
                }

                if (j == chars.length-1) {
                    tempTrie.child[chars[j]-'a'].endWord = true;
                }
                
                tempTrie = tempTrie.child[chars[j]-'a'];
            }
        }

        List<String> ans = new ArrayList<>();
        for(int i=0 ; i < words.length ; i++) {
            boolean f[] = new boolean[words[i].length()];
            if (matchStr(root, words[i], 0, f)) {
                ans.add(words[i]);
            }
        }

        return ans;
    }
}