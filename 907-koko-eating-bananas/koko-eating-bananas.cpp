class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int l = 1 ;
        int r = 1000000000;
        int ans = r;

        while(l<=r) {
            int mid = (l+r)/2;
            long totalTime = tryToEat(piles, mid);
            if (totalTime <= h) {
                ans = min(ans, mid);
            }

            if (totalTime > h) {
                l = mid+1; // increase mid;
            } else {
                r = mid-1; // decrease mid;
            }
        }

        return ans ;
    }

    long tryToEat(vector<int>& piles, int speed) {
        long sum = 0 ; 
        
        for(int i = 0 ; i< piles.size() ; i++) {
            sum += piles[i]/speed + (piles[i]%speed > 0 ? 1 : 0);
        }
        
        return sum ;
    }
};


// min k = 1 
// max k = h = 1000000000
// 