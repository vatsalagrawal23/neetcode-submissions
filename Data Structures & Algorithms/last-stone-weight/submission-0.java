class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int n = stones.length;
        for(int i = 0; i < n; i++) {
            pq.add(stones[i]);
        }

        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            int c = a - b;
            if(c > 0) {
                pq.add(c);
            }
        }

        if(pq.size() == 1) {
            return pq.poll();
        }

        return 0;
    }
}
