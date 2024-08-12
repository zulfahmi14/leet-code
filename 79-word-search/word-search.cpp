class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        int row = board.size();
        int col = board[0].size();
        vector<vector<bool>> f(row, vector<bool>(col, false));

        for(int i = 0;i < row;i++) {
            for(int j = 0;j < col;j++) {
                if(dfs(board, word, f, i, j, 1)) return true;
            }
        }

        return false;
    }

    bool dfs(vector<vector<char>>& board, string word, vector<vector<bool>>& f, int row, int col, int valid) {
        if(row < 0 || col < 0 || row >= board.size() || col >= board[0].size()) {
            return false;
        }

        if(f[row][col] || board[row][col] != word[valid-1]) { // visited || not same
            return false ;
        }

        if (word.length() == valid) {
            return true ;
        }

        f[row][col] = true ;
        bool a1 = dfs(board, word, f, row+1, col, valid+1);
        bool a2 = dfs(board, word, f, row-1, col, valid+1);
        bool a3 = dfs(board, word, f, row, col+1, valid+1);
        bool a4 = dfs(board, word, f, row, col-1, valid+1);
        f[row][col] = false ; // backtracking

        return a1 || a2 || a3 || a4;
    }
};