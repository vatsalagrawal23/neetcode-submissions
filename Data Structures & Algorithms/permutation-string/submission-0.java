class Solution {
    public boolean check(int[] s1, int[] s2) {
        for(int i = 0; i < 26; i++) {
            if(s1[i] != s2[i]) {
                return false;
            }
        }

        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(m < n) {
            return false;
        }

        int a[] = new int[26];
        int b[] = new int [26];

        for(int i = 0; i < n; i++) {
            int x = s1.charAt(i) - 'a';
            int y = s2.charAt(i) - 'a';
            int tmpA = a[x];
            int tmpB = b[y];
            a[x] = tmpA+1;
            b[y] = tmpB+1;
        }

        for(int i = n; i < m; i++) {
            if(check(a, b)) {
                return true;
            }
            int x = s2.charAt(i) - 'a';
            int tmpA = b[x];
            b[x] = tmpA + 1;

            int y = s2.charAt(i - n) - 'a';
            int tmpB = b[y];
            b[y] = tmpB - 1;
        }

        return check(a, b);
    }
}
