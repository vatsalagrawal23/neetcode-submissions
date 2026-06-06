class Solution {
    public boolean check(int[] a , int[] b) {
        for(int i = 0; i < 100; i++) {
            if(a[i] > b[i]) {
                return false;
            }
        }

        return true;
    }
    public String minWindow(String s, String t) {
        int a[] = new int[100];
        int b[] = new int[100];

        int n = s.length();
        int m = t.length();

        for(int i = 0; i < m; i++) {
            int x = t.charAt(i) - 'A';
            int tmpA = a[x];
            a[x] = tmpA + 1;
        }


        int l = 0;
        int lMin = -1;
        int rMin = -1;
        int minLen = n+2;

        for(int i = 0; i < n; i++) {
            int x = s.charAt(i) - 'A';
            int tmpA = b[x];
            b[x] = tmpA + 1;
            boolean res = check(a, b);
            while(l < n && check(a, b)) {
                int tmp = i - l + 1;
                if(minLen > tmp) {
                    lMin = l;
                    rMin = i;
                    minLen = tmp;
                }
                l++;
                int y = s.charAt(l-1) - 'A';
                int tmpB = b[y];
                b[y] = tmpB - 1;
            }
        }

        if(lMin == -1 || rMin == -1) {
            return "";
        }

        String ans = s.substring(lMin, rMin+1);
        return ans;
    }
}
