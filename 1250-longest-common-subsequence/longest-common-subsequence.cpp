class Solution {
public:
    int arr[1001][1001] ;
    
    int dp(string &text1, string &text2, int idx1, int idx2) {
        if (idx1 >= text1.length() || idx2 >= text2.length()) return 0 ;
        if (arr[idx1][idx2] != -1) return arr[idx1][idx2] ;
        
        int ans = 0 ;
        if (text1[idx1] == text2[idx2]) {
            ans = 1 + dp(text1, text2, idx1+1, idx2+1);
        } else {
            ans += max(dp(text1, text2, idx1+1, idx2), dp(text1, text2, idx1, idx2+1));            
        }
        
        arr[idx1][idx2] = ans ;
               
        return ans ;
    }
    
    int longestCommonSubsequence(string text1, string text2) {
        memset(arr,-1,1001*1001*sizeof(int));
        return dp(text1, text2, 0, 0) ;
    }
};