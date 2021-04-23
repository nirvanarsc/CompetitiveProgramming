package binarysearch.weekly_52;

public class P_1 {

    public boolean solve(String s) {
        int lo = 0;
        int hi = s.length() - 1;
        while (lo < hi) {
            final char l = s.charAt(lo);
            final char r = s.charAt(hi);
            if (!('a' <= l && l <= 'z')) {
                lo++;
            } else if (!('a' <= r && r <= 'z')) {
                hi--;
            } else if (l != r) {
                return false;
            } else {
                lo++;
                hi--;
            }
        }
        return true;
    }
}
