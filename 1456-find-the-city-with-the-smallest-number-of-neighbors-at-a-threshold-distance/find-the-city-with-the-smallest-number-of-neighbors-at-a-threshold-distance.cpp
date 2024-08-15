class Solution {
public:

    // struct cmp {
    //     bool operator(pair<int,int>& a, pair<int,int>& b) {
    //         return a.first < b.first;
    //     }
    // }


    int reachCity(int n, unordered_map<int, unordered_map<int, int>>& m, int city, int limit) {
        priority_queue<pair<int,int>, vector<pair<int, int>>, greater<pair<int, int>>> q;
        vector<bool> v(n, false);
        int ans = 0;
        q.push({0, city});

        while(!q.empty()) {
            pair<int,int> nextCity = q.top();
            q.pop();

            if(v[nextCity.second] || nextCity.first > limit) {
                continue;
            }

            v[nextCity.second] = true;
            if(nextCity.second != city && nextCity.first<= limit) ans++;


            // if(city == 4) {
            //         cout << nextCity.first << " " << nextCity.second << endl;
            //     }

            for(auto mm : m[nextCity.second]) {

                if (mm.second+nextCity.first <= limit) {
                    q.push({mm.second+nextCity.first, mm.first});
                    // if (!v[mm.first]) {
                    //     v[mm.first] = true;
                    //     ans++;
                    // }
                }
            }
        }

        return ans ;
    }


    int findTheCity(int n, vector<vector<int>>& edges, int distanceThreshold) {
        unordered_map<int, unordered_map<int, int>> m; // weight from city i to city j
        vector<int> v;
        int ans = -1;

        for(int i=0 ; i<edges.size() ;i++) {
            m[edges[i][0]][edges[i][1]] = edges[i][2];
            m[edges[i][1]][edges[i][0]] = edges[i][2];
        }

        for(int i=0;i<n;i++) {
            v.push_back(reachCity(n, m, i, distanceThreshold));
        }

        int minCity = INT_MAX;


        for(int i=0;i<n;i++) { 
            cout << v[i] << " ";
            if(v[i] <= minCity) {
                minCity = v[i]; ans = i;
            }
        }

        return ans;
    }
};


// loop each city
// convert edge to 2D map
// do dijkstra, reach asmuch as possible cities
