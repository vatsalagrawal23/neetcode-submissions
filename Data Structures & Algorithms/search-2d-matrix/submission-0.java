class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while(l <= h) {
            int mid = l + (h - l)/2;
            if(nums[mid] == target) {
                return true;
            }
            else if(nums[mid] >= target) {
                h = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i < n; i++) {
            if(matrix[i][0] <= target && matrix[i][m-1] >= target) {
                return search(matrix[i], target);
            }
        }
        return false;
    }
}
