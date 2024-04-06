class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        map<string, int> map ;
        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 0 ; j < 9 ; j++) {
                if (board[i][j] != '.') {
                    if (map["row" + to_string(i) + board[i][j]] || map["col" + to_string(j) + board[i][j]] || map["sq" + to_string(i/3) + to_string(j/3) + board[i][j]]) return false;

                    map["row" + to_string(i) + board[i][j]] = 1;
                    map["col" + to_string(j) + board[i][j]] = 1;
                    map["sq" + to_string(i/3) + to_string(j/3) + board[i][j]] = 1;
                }
            }
        }

        return true;
    }
};