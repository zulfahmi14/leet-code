public class Data {
    public int i;
    public int j;
    public int length;

    public Data() {

    }

    public Data(int i, int j, int length) {
        this.i = i;
        this.j = j;
        this.length = length;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        PriorityQueue<Data> pq = new PriorityQueue<>((a,b) -> a.length - b.length);
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] f = new boolean[n][m];

        pq.add(new Data(0,0,1));

        while(!pq.isEmpty()) {
            Data d = pq.poll(); // get & pop!

            if(d.i < 0 || d.i >=n || d.j < 0 || d.j >= m || f[d.i][d.j] == true || grid[d.i][d.j] == 1) {
                continue;
            }

            // visited.
            f[d.i][d.j] = true;

            if (d.i == n-1 && d.j == m-1) {
                return d.length;
            }

            pq.add(new Data(d.i+1, d.j, d.length+1));
            pq.add(new Data(d.i, d.j+1, d.length+1));
            pq.add(new Data(d.i-1, d.j, d.length+1));
            pq.add(new Data(d.i, d.j-1, d.length+1));
            pq.add(new Data(d.i+1, d.j+1, d.length+1));
            pq.add(new Data(d.i-1, d.j-1, d.length+1));
            pq.add(new Data(d.i+1, d.j-1, d.length+1));
            pq.add(new Data(d.i-1, d.j+1, d.length+1));
        }

        return -1;
    }
}