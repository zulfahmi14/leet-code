class Solution {
public:
    int characterReplacement(string s, int k) {
        int ans = 0 ;
        for(char c = 'A' ; c <= 'Z' ; c++) { // ASCII
            ans = max(ans, doSlide(s, k, c));
        }

        return ans ;
    }

    int doSlide(string s, int k, char mainChar) {
        int l = 0 ;
        int r = 0 ;
        int ans = 0 ;
        int temp = k ;
        while(l < s.length()) {
            if(mainChar == s[r] && r < s.length() && temp>=0) {
                r++ ;
                ans = max(ans,r-l);
            } else if (mainChar != s[r] && temp>0 && r < s.length()) {
                r++;
                temp--;
                ans = max(ans,r-l);
            } else {
                if (mainChar != s[l]) {
                    temp++ ;
                }
                l++;
            }
        }

        return ans ;
    }
};