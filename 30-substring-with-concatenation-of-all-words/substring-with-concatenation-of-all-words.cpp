class Solution {
private:
    bool okk(string s, int i, map<string, int>& map, int wordLen, int wordSize) {
        while(wordSize>0) {
            if (map[s.substr(i, wordLen)] > 0) {
                map[s.substr(i, wordLen)]--;
                wordSize--;
            } else {
                return false;
            }
            i+=wordLen;
        }

        return true;
    }

public:
    vector<int> findSubstring(string s, vector<string>& words) {
    
        map<string, int> m;
        map<string, int> bm;
        vector<int> ans;
        int wordSize = words.size();
        int wordLen = words[0].length();
        bool seen = false;

        if (wordSize*wordLen > s.length()) return ans;

        // initiate and reset map.
        for(int i=0 ; i< words.size() ; i++) {
            bm[words[i]]++;
        }

        // no idea. special treatment!
        if (bm.size() == 1) {
            string tempStr = "";
            for(int i=0 ; i<words.size() ; i++) {
                tempStr+=words[i];
            }

            for (int i=0; i <= s.length()-(wordSize*wordLen) ; i++) {
                if (s.substr(i, wordSize*wordLen) == tempStr) ans.push_back(i);
            }

            return ans;
        }

        // sliding windows!
        for(int i=0 ; i<= s.length()-(wordSize*wordLen) ; i++) {
            // no need to itterate all substr. just test the new segment after jumping the index i.
            if (seen) {
                if (m[s.substr((i+((wordSize-1)*wordLen)), wordLen)]>0) {
                    ans.push_back(i);
                    seen = true;

                    // jump the i again.
                    m[s.substr((i+((wordSize-1)*wordLen)), wordLen)]--;
                    m[s.substr(i, wordLen)]++;

                    i+=(wordLen-1);
                } else {
                    seen = false;
                }

                continue;
            }

            // initiate and reset map.
            m=bm;

            if (okk(s, i, m, wordLen, wordSize)) {
                ans.push_back(i);
                seen = true;

                // jump the i
                m[s.substr(i, wordLen)]++;

                i+=(wordLen-1);
            } else {
                seen = false;
            }
        }

        return ans;
    }
};