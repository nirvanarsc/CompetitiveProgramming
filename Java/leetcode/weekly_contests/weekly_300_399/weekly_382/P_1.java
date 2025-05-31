package leetcode.weekly_contests.weekly_300_399.weekly_382;

public class P_1 {

    public int countKeyChanges(String s) {
        int res = 0;
        s = s.toLowerCase();
        final char[] w = s.toCharArray();
        char lastKey = w[0];
        for (int i = 1; i < s.length(); i++) {
            final char currentKey = w[i];
            if (currentKey != lastKey) {
                res++;
                lastKey = currentKey;
            }
        }
        return res;
    }
}
