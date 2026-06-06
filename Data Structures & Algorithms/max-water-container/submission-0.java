class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int ans = 0;
        int left = 0;
        int right = n-1;
        while(left < right) {
            int min = Math.min(heights[left], heights[right]);
            int tmp = right - left;
            int cur = tmp*min;
            ans = Math.max(cur, ans);
            if(heights[left] == min) {
                left++;
            }
            else {
                right--;
            }
        }

        return ans;
    }
}
