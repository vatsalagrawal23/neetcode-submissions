class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] < nums[r]) {
                r = mid;
            }
            else {
                l = mid+1;
            }
        }
        return l;
    }

    public int find(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int minIndex = findMin(nums);
        if (target >= nums[minIndex] && target <= nums[n - 1]) {
            return find(nums, minIndex, n - 1, target);
        } else {
            return find(nums, 0, minIndex - 1, target);
        }
    }
}
