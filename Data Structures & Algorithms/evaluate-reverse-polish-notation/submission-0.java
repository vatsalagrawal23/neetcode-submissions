class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        int n = tokens.length;
        for(int i = 0; i < n; i++) {
            if(tokens[i].equals("+")) {
                int a = Integer.parseInt(st.pop());
                int b = Integer.parseInt(st.pop());
                int sum = a + b;
                st.push("" + sum);
            }

            else if(tokens[i].equals("-")) {
                int a = Integer.parseInt(st.pop());
                int b = Integer.parseInt(st.pop());
                int diff = b - a;
                st.push("" + diff);
            }

            else if(tokens[i].equals("*")) {
                int a = Integer.parseInt(st.pop());
                int b = Integer.parseInt(st.pop());
                int prod = b * a;
                st.push("" + prod);
            }

            else if(tokens[i].equals("/")) {
                int a = Integer.parseInt(st.pop());
                int b = Integer.parseInt(st.pop());
                int div = b/a;
                st.push("" + div);
            }

            else {
                st.push(tokens[i]);
            }
        }

        return Integer.parseInt(st.pop());
    }
}
