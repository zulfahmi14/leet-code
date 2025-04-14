class Solution {
    Map<Integer, Map<Integer, Boolean>> f = new HashMap<>();

    private void dfs(char[][] grid, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m || f.getOrDefault(i, new HashMap<>()).get(j) != null || grid[i][j] == '0') return ;

        f.putIfAbsent(i, new HashMap<>());
        f.getOrDefault(i, new HashMap<>()).put(j, true);

        dfs(grid, i+1, j, n, m);
        dfs(grid, i, j+1, n, m);
        dfs(grid, i, j-1, n, m);
        dfs(grid, i-1, j, n, m);
    }

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for(int i =0 ;i <n ;i++) {
            for(int j = 0 ; j < m ; j++) {
                if(grid[i][j] == '1' && f.getOrDefault(i, new HashMap<>()).get(j) == null) {
                    ans++;
                    dfs(grid,i,j,n,m);
                }
            }
        }

        return ans;
    }
}