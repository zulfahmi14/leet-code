class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minVal = prices[0];
        int profit = 0;
        for(int i=1;i<prices.size();i++) {
            if (profit < prices[i]-minVal) {
                profit = prices[i]-minVal;
            }
            if (minVal > prices[i]) {
                minVal = prices[i];
            }
        }

        return profit;
    }
};