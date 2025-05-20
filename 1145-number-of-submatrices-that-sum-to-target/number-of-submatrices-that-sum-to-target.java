class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] prevsum = new int[n+1][m+1];
        int ans = 0;

        for(int i= 1 ; i <= n ;i ++) {
            for(int j = 1; j <= m ; j++) {
                prevsum[i][j] = matrix[i-1][j-1] + (prevsum[i][j-1] + prevsum[i-1][j] - prevsum[i-1][j-1]);
            }
        }

        for(int i = 1 ; i <=n ; i++) {
            for(int j=1 ; j <= m ; j++) {
                for(int k = i ; k <=n ; k++) {
                    int sum = 0;
                    for(int l=j ; l <= m ; l++) {
                        sum = prevsum[k][l] - prevsum[i-1][l]-prevsum[k][j-1] + prevsum[i-1][j-1];

                        if (i == n && j == m && k == n && l == m) {
                            System.out.println(sum);
                        }

                        if (sum == target) {
                            ans++;
                        }
                    }
                }
            }
        }

        return ans;
    }
}