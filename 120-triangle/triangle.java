class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i =1 ; i < triangle.size() ; i++) {
            for(int j = 0 ; j< triangle.get(i).size() ; j++) {
                if (j == 0) triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j));
                else if (j == triangle.get(i).size()-1) triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j-1));
                else triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j), triangle.get(i-1).get(j-1)));
            }
        }

        int ans = triangle.get(triangle.size()-1).get(0);
        for(int j = 0 ; j< triangle.get(triangle.size()-1).size() ; j++) {
            ans = Math.min(ans, triangle.get(triangle.size()-1).get(j));
        }

        return ans;
    }
}
