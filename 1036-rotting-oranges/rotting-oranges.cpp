class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        queue<pair<pair<int, int>, int>> q ; // row, col, and minutes become rotten
        int ans = 0;

        for(int i=0;i<grid.size() ;i++) {
            for(int j=0;j<grid[0].size();j++) {
                if(grid[i][j] == 2) q.push({{i,j}, 0});
            }
        }

        while(!q.empty()) {
            pair<pair<int, int>, int> r = q.front();
            q.pop();

            if(r.first.first < 0 || r.first.first >= grid.size() || 
                r.first.second < 0 || r.first.second >= grid[0].size())
                continue;

            if(grid[r.first.first][r.first.second] == 3 || grid[r.first.first][r.first.second] == 0) {
                continue;
            }

            ans = max(r.second, ans);
            grid[r.first.first][r.first.second] = 3; // being rotten -> inititate new number!
            q.push({{r.first.first+1,r.first.second}, r.second+1});
            q.push({{r.first.first-1,r.first.second}, r.second+1});
            q.push({{r.first.first,r.first.second+1}, r.second+1});
            q.push({{r.first.first,r.first.second-1}, r.second+1});
        }

        for(int i=0;i<grid.size() ;i++) {
            for(int j=0;j<grid[0].size();j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return ans;
    }
};