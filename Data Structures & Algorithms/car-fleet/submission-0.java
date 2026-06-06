class Solution {
        public class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
        public int carFleet(int target, int[] position, int[] speed) {
            int n = position.length;
            Pair cars[] = new Pair[n];
            for (int i = 0; i < n; i++) {
                Pair p = new Pair(position[i], speed[i]);
                cars[i] = p;
            }

            Arrays.sort(cars, (a, b) -> b.a - a.a);

            double time[] = new double[n];
            for (int i = 0; i < n; i++) {
                double curTime = (double) (target - cars[i].a) / cars[i].b;
                time[i] = curTime;
            }

            Stack<Double> st = new Stack<>();
            for (int i = 0; i < n; i++) {
                if(st.isEmpty()) {
                    st.push(time[i]);
                }
                
                else if(st.peek() < time[i]) {
                    st.push(time[i]);
                }
            }
            
            return st.size();
        }
}
