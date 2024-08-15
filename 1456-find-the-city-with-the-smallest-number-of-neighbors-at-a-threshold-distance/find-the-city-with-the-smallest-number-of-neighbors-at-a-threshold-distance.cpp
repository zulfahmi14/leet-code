class Solution {
public:
    int findTheCity(int n, vector<vector<int>>& edges, int distanceThreshold) {
        long maxInt = INT_MAX;
        vector<vector<long>> m(n+1, vector<long>(n+1, maxInt*n)); // -1 means infinite.
        long ans = -1;
        long smallestDist = maxInt*n;

        for(auto i : edges) {
            m[i[0]][i[1]] = i[2];
            m[i[1]][i[0]] = i[2];
        }

        for (int i = 0; i < n; i++) 
            m[i][i] = 0;

        for(int k =0; k < n ; k++) {
            for(int i=0; i < n ; i++) {
                for(int j=0; j< n ; j++) {
                    m[i][j] = min(m[i][j], m[i][k] + m[k][j]);
                }
            }
        }

        for(int i =0; i < n ; i++) {
            long sum = -1;
            for(int j = 0 ; j<n ; j++) {
                if (m[i][j] <= distanceThreshold) {
                    sum++;
                } 
            }
            
            if (sum <= smallestDist) {
                smallestDist = sum;
                ans = i;
            }
        }

        return ans;
    }
};

// by floyd warshall
// create matrix n-n