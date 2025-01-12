class Solution {
public:
    int maxProfit(vector<int>& prices) {

        int profit = 0;
        int maxProfit = 0;
        int buyVal = prices[0];

       for(int i = 1 ; i < prices.size() ;i++) {

            // reset
            if (prices[i] < prices[i-1]) {
                profit = max(0, prices[i-1] - buyVal);
                maxProfit = maxProfit + profit;
                buyVal = prices[i];
            } else if (i == prices.size()-1) {
                profit = max(0, prices[i] - buyVal);
                maxProfit = maxProfit + profit;
                break;
            }
       }

       return maxProfit;
    }
};