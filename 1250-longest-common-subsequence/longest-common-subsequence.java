class Solution {
    private int dp(char[] text1, char[] text2, int idx1, int idx2, int[][] f) {
        if (idx1 >= text1.length || idx2 >= text2.length) {
            return 0;
        }

        if (f[idx1][idx2] != -1) {
            return f[idx1][idx2];
        }

        if(text1[idx1] == text2[idx2]) {
            f[idx1][idx2] = 1 + dp(text1, text2, idx1+1, idx2+1, f);
        } else {
            int f1 = dp(text1, text2, idx1, idx2+1, f);
            int s = dp(text1, text2, idx1+1, idx2, f);
            f[idx1][idx2] = Math.max(f1,s);
        }

        return f[idx1][idx2];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int[][] f = new int[t1.length][t2.length];

        for(int i=0;i < t1.length ; i++) {
            Arrays.fill(f[i], -1);
        }

        return dp(t1, t2, 0, 0, f);
    }
}