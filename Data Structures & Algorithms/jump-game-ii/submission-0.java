class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int targetGoal = n-1;
        if (targetGoal <= 0) {
            return 0;
        }
        
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // Update the maximum reach we can achieve from the current index
            farthest = Math.max(farthest, nums[i] + i);
            
            // If our farthest reach can already hit or cross the goal, 
            // we just need one more jump from the current interval
            if (farthest >= targetGoal) {
                return jumps + 1;
            }
            
            // If we have reached the end of the current jump's range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                
                // If we get stuck and cannot make any forward progress
                if (currentEnd <= i) {
                    return -1; // Goal is unreachable
                }
            }
        }
        
        return -1;
    }
}
