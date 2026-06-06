class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int max = 0;
        int maxf = 0;
        int n = s.length();

        Map<Character, Integer> x = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int cnt = x.getOrDefault(s.charAt(i), 0) + 1;
            x.put(s.charAt(i), cnt);
            maxf = Math.max(maxf, cnt);
            while((i - l + 1) - maxf > k ) {
                int cnt1 = x.get(s.charAt(l));
                x.put(s.charAt(l), cnt1 - 1);
                l++;
            }

            max = Math.max(max, i - l + 1);
        }

        return max;
    }
}
