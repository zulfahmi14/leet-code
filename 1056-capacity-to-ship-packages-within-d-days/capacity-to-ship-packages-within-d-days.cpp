class Solution {
public:
    int shipWithinDays(vector<int>& weights, int days) {
        int ans = 500*50000 + 1;
        int l = weights[weights.size()-1];
        int r = 500*50000;

        for(int i=0 ;i < weights.size() ; i++) {
            if (l < weights[i]) l = weights[i];
        }

        while(l <= r) {
            int mid = (l+r)/2;
            int actualDays = getdays(weights, mid);
            if ( actualDays <= days) {
                ans = min(mid, ans);
            }

            if (actualDays > days) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        return ans;
    }

    int getdays(vector<int>& weights, int weight) {
        int days = 0;
        for(int i =0; i < weights.size(); i++) {
            int temp = weights[i];
            while(temp < weight && i < weights.size()-1 && temp + weights[i+1] <= weight) {
                i++;
                temp = temp + weights[i];
            }

            days++;
        }

        return days;
    }
};

// min -> max package weight -> 10
// sorting, then sum of last (length/days) highest value. -> 19

