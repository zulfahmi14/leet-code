class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        bool up = false, down = false, left = false, right = true;
        int total = 0;
        int i = 0, j = 0;
        vector<int> ans;
        map<int, map<int, bool>> f;

        while(true) {
            ans.push_back(matrix[i][j]);
            f[i][j] = true;

            total++;
            if (total >= matrix.size()*matrix[i].size()) break;

            if (right) {
                if (j+1 < matrix[0].size() && f[i][j+1] == false) {
                    j++;
                } else {
                    down = true;
                    right = false;
                    i++;
                }
            } else if (down) {
                if (i+1 < matrix.size() && f[i+1][j] == false) {
                    i++;
                } else {
                    down = false;
                    left = true;
                    j--;
                }
            } else if (left) {
                if (j-1 >= 0 && f[i][j-1] == false) {
                    j--;
                } else {
                    left = false;
                    up = true;
                    i--;
                }
            } else {
                if (i-1 >= 0 && f[i-1][j] == false) {
                    i--;
                } else {
                    up = false;
                    right = true;
                    j++;
                }
            }
        }

        return ans;
    }
};