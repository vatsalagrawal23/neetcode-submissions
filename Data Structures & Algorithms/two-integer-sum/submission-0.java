class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> x = new HashMap<>();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++) {
            int y = target - nums[i];
            if(x.containsKey(y)) {
                int ans [] = new int [2];
                ans[0] = x.get(y);
                ans[1] = i;

                return ans;
            }

            else {
                x.put(nums[i], i);
            }
        }

        int ans[] = new int [2];
        return ans;
    }
}
