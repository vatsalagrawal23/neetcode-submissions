class Solution {
    public boolean fun(int[] piles, int h, int cur) {
        int n = piles.length;
        int hour = 0;

        for(int i = 0; i < n; i++) {
            int x = (int) Math.ceil((double) piles[i]/ cur);
            hour+=x;
        }

        return h >= hour;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int n = piles.length;
        int max = 0;
        for(int i = 0; i < n; i++) {
             max = Math.max(max, piles[i]);
        }

        int he = max;
        int ans = max;
        while(l <= he) {
            int mid = l + (he - l)/2;
            if(fun(piles, h, mid)) {
                ans = Math.min(mid, ans);
                he = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        return ans;
    }
}
