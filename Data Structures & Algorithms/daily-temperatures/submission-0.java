class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int index [] = new int [n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i >= 0; i--) {
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }

            if(st.isEmpty()) {
                index[i] = -1;
            }
            else {
                index[i] = st.peek();
            }

            st.push(i);
        }

        int ans [] = new int[n];
        for(int i = 0; i < n; i ++) {
            if(index[i] == -1) {
                ans[i] = 0;
            }
            else {
                ans[i] = index[i] - i;
            }
        }

        return ans;
    }
}
