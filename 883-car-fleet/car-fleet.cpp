class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        int ans  = 1;
        vector<pair<int, double>> v ;
        for(int i = 0 ;i<speed.size() ;i++) {
            v.push_back({position[i], (target-position[i])*1.0/speed[i]});
        }

        sort(v.begin(), v.end());

        // some cars slowing their speed due to stuck by the next car
        for(int i = position.size()-2 ; i >= 0 ; i--) {
            if(v[i].second < v[i+1].second) {
                v[i] = {v[i].first, v[i+1].second};
            }
        }

        for(int i = 1 ; i < position.size() ; i++) {
            if(v[i-1].second > v[i].second) { // if the prev car slower, it'll split the queue
                ans++ ;
            }
        }

        return ans ;
    }
};



// 0, 10/2 = 5
// 2, 8/3 = 6
// 4, 6/1 = 6