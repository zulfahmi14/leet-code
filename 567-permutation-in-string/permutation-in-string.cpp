class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        if (s2.length() < s1.length()) return false;

        map<char,int> map1 ;
        for(int i = 0 ; i < s1.length() ; i++) {
            map1[s1[i]]++ ;
        }

        sort(s1.begin(), s1.end());

        for(int i = 0 ; i <= s2.length()-s1.length() ; i++) {
            if(unorderedMatch(s1, s2.substr(i, s1.length())))
                return true;
        }

        return false ;
    }

    bool unorderedMatch(string s1, string substr) {
        sort(substr.begin(), substr.end());
        return s1 == substr;
    }
};

// 0 1 2 3