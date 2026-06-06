class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int smallerLeft [] = new int[n];
        int smallerRight [] = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if(st.isEmpty()) {
                smallerLeft[i] = -1;
            }
            else {
                smallerLeft[i] = st.peek();
            }

            st.push(i);
        }

        st = new Stack<>();
        for(int i = n-1 ; i >= 0; i--) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                smallerRight[i] = n;
            }
            else {
                smallerRight[i] = st.peek();
            }
            st.push(i);
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            int left = i - smallerLeft[i] - 1;
            int right = smallerRight[i] - i;
            int tmp = (left + right)*heights[i];
            max = Math.max(tmp, max);
        }

        return max;
    }
}
