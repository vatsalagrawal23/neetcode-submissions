class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        int a[] = new int[1001];
        for(int i = 0; i < n; i++) {
            a[hand[i]] = a[hand[i]] + 1;
        }
        for(int i = 0; i <= (1000 - groupSize + 1); i++) {
            if(a[i] > 0) {
                for(int j = i+1; j < i+groupSize; j++) {
                    if(a[j] < a[i]) {
                        return false;
                    }
                    else {
                        a[j] = a[j] - a[i];
                    }
                }
            }
        }

        for(int i = (1000 - groupSize); i < 1001; i++) {
            if(a[i] > 0) {
                return false;
            }
        }

        return true;
    }
}
