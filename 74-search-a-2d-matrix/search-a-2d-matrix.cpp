class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int col = matrix[0].size();
        int l = 0 ;
        int r = (matrix.size()*col)-1;
        
        while(l <= r) {
            int mid = (l+r)/2;
            if (matrix[mid/col][mid%col] == target) {
                return true ;
            }

            if(matrix[mid/col][mid%col] > target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        return false;
    }
};

// same as classic binser

// 0,1
// 2,3
// 4,5

// 3x2 size -> idx 4
// meaning : 
// 4/2 (column) = 2 (in row 2) (start from 0)
// 4%2 (column) = 0 (in column 0)

// idx 5
// 5/2 -> 2
// 5%2 -> 1