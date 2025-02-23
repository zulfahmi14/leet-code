class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    int ans = 0;
    int reqGas = 0;
    int excessGas = 0;
    
    for(int i = 0; i < gas.length ; i++) {
      excessGas += gas[i];

      if (excessGas < cost[i]) {
        reqGas = reqGas + (cost[i]-excessGas);
        ans = i+1;
        excessGas = 0;
        // System.out.println("req " + reqGas);
      } else {
        excessGas = excessGas - cost[i];
        // System.out.println("ex " + excessGas);
      }
    }

    if (ans >= gas.length || (reqGas > excessGas)) {
      return -1;
    }

    return ans;
    }
}