class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack();
        int n = s.length();
        int i = 0;
        while(i < n) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            }

            else if (s.charAt(i) == ')') {
                if(st.isEmpty()) {
                    return false;
                }

                Character x = st.pop();
                if(x != '(') {
                    return false;
                }
            }

            else if (s.charAt(i) == '}') {
                if(st.isEmpty()) {
                    return false;
                }

                Character x = st.pop();
                if(x != '{') {
                    return false;
                }
            }

            else if (s.charAt(i) == ']') {
                if(st.isEmpty()) {
                    return false;
                }

                Character x = st.pop();
                if(x != '[') {
                    return false;
                }
            }

            i++;
        }

        return st.isEmpty();
    }
}
