class KthLargest {
    public PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int s = 0;
    public KthLargest(int k, int[] nums) {
        int n = nums.length;
        s = k;
        for(int i = 0; i < n; i++) {
            pq.add(nums[i]);
        }
        while(pq.size() > k) {
            pq.poll();
        }
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size() > s) {
            pq.poll();
        }

        return pq.peek();
    }
}
