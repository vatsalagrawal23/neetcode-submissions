class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int sum = 0;
        int curMin = prices[0];
        for(int i = 1; i < n; i++) {
            if(curMin < prices[i]) {
                int tmp = prices[i] - curMin;
                sum = Math.max(sum, tmp);
            }
            else {
                curMin = prices[i];
            }
        }

        return sum;
    }
}
