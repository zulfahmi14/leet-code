class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        map<int, vector<int>> map ;
        for (int i =0 ; i < numbers.size() ; i++ ) {
            map[numbers[i]].push_back(i+1);
        }

        for (auto it=map.begin(); it!=map.end(); ++it) {
            if (map.contains(target-it->first)) {
                int idx2 = 0;
                if (it->first == target-it->first) {
                    idx2 = 1;
                }

                return {it->second[0], map[target-it->first][idx2]};
            }
        }

        return {-1, -1};
    }
};