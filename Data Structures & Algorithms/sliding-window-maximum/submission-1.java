class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> x = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!x.isEmpty() && nums[x.getLast()] <= nums[i]) {
                x.removeLast();
            }
            x.addLast(i);
        }

        List<Integer> tmp = new ArrayList<>();
        tmp.add(nums[x.getFirst()]);

        for (int i = k; i < n; i++) {
            while (!x.isEmpty() && x.getFirst() <= i-k) {
                x.removeFirst();
            }
            while (!x.isEmpty() && nums[x.getLast()] <= nums[i]) {
                x.removeLast();
            }
            x.addLast(i);
            tmp.add(nums[x.getFirst()]);
        }

        int ns = tmp.size();
        int ans[] = new int[ns];
        for(int i = 0; i < ns; i++) {
            ans[i] = tmp.get(i);
        }

        return ans;
    }

}
