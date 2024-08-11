class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int latestIdx[102] = { [0 ... 101] = 2000000 };
        vector<int> v ;

        for(int i=temperatures.size()-1 ; i >=0  ; i--) {
            int minIdx = 2000000 ;
            for(int j=temperatures[i]+1 ; j<=100 ; j++) {
                minIdx = min(minIdx, latestIdx[j]);
            }

            if (minIdx != 2000000) {
                v.push_back(minIdx-i);
            } else {
                v.push_back(0);
            }

            latestIdx[temperatures[i]] = i;
        }

        // cout<< latestIdx[73] ;
        reverse(v.begin(), v.end());
        return v;
    }
};
