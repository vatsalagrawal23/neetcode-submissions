class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        Set<Integer>x = new HashSet<>();
        for(int i = 0; i < n; i++) {
            if(x.contains(nums[i])) {
                return true;
            }

            x.add(nums[i]);
        }

        return false;
    }
}
