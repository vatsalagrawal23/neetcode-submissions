class MinStack {
    private Stack<int []> s;
    private Integer min;
    public MinStack() {
        s = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        int newMin = s.isEmpty() ? x : Math.min(x, s.peek()[1]);
        s.push(new int[]{x, newMin});
    }
    
    public void pop() {
        if (!s.isEmpty()) {
            s.pop();
        }
    }
    
    public int top() {
        return s.isEmpty() ? -1 : s.peek()[0];
    }
    
    public int getMin() {
        return s.isEmpty() ? -1 : s.peek()[1];
    }
}
