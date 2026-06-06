class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i = 0;
        int j = n-1;
        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if(sum == target) {
                int ans[] = new int[2];
                ans[0] = i+1;
                ans[1] = j+1;
                return ans;
            }
            if(sum < target) {
                i++;
            }

            else {
                j--;
            }
        }

        int ans[] = new int[2];
        return ans;
    }
}
