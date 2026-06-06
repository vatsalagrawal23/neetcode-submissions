class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = nums[0];
        int index = 0;
        while (l <= r) {
            if (nums[l] <= nums[r]) {
                if (nums[l] < min) {
                    min = nums[l];
                    index = l;
                }
                break;
            }
            int mid = l + (r - l) / 2;
            if (min > nums[mid]) {
                min = nums[mid];
                index = mid;
            }
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return index;
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
