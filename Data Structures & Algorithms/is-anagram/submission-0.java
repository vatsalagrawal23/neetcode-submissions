class Solution {
    public boolean isAnagram(String s, String t) {
        int a = s.length();
        int b = t.length();

        if(a != b) {
            return false;
        }

        Map<Character, Integer> x = new HashMap<>();
        for(int i = 0; i < a; i++) {
            int tmp = x.getOrDefault(s.charAt(i), 0);
            x.put(s.charAt(i), tmp + 1);

            int tmp1 = x.getOrDefault(t.charAt(i), 0);
            x.put(t.charAt(i), tmp1 - 1);
        }

        for(Character p : x.keySet()) {
            if(x.get(p) != 0) {
                return false;
            }
        }

        return true;
    }
}
