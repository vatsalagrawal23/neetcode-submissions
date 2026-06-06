  class Solution {
        public  class Dis {
            int [] coordinate;
            double dis;
            public Dis(int [] coordinate, double dis) {
                this.coordinate = coordinate;
                this.dis = dis;
            }
        }
        public  int[][] kClosest(int[][] points, int k) {
            int n  = points.length;
            PriorityQueue<Dis> pq = new PriorityQueue<>((a, b) -> Double.compare(b.dis, a.dis));
            for(int i = 0; i < n; i++) {
                double curDis = Math.sqrt(Math.pow(points[i][0], 2.0) + Math.pow(points[i][1], 2.0));
                pq.add(new Dis(points[i], curDis));
                while(pq.size() > k) {
                    pq.poll();
                }
            }

            int [][] ans = new int[k][2];
            int i = 0;
            while (!pq.isEmpty()) {
                ans[i] = pq.poll().coordinate;
                i++;
            }

            return ans;
        }
    }