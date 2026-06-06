class Solution {
    public int robImpl(int[] nums, int l, int r) {
        int m = r - l;
        if(m == 1) {
            return nums[l];
        } 
        else if(m == 2) {
            return Math.max(nums[l], nums[r-1]);
        }
        int dp[] = new int[m];
        dp[0] = nums[l];
        dp[1] = Math.max(nums[l], nums[l+1]);
        for(int i = l+2; i < r; i++) {
            dp[i-l] = Math.max(dp[i-l-1], dp[i-l-2] + nums[i]);
        }

        return dp[m-1];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        else if(n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(robImpl(nums, 0, n-1), robImpl(nums, 1, n));
    }
}
