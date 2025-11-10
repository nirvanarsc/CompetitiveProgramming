package leetcode.biweekly_contests.biweekly_100_199.biweekly_168;

public class P_1 {

    public String lexSmallest(String s) {
        String res = s;
        final int n = s.length();
        for (int i = 0; i < n; i++) {
            String next = new StringBuilder(s.substring(0, i + 1)).reverse() + s.substring(i + 1);
            if (next.compareTo(res) < 0) {
                res = next;
            }
            next = s.substring(0, i + 1) + new StringBuilder(s.substring(i + 1)).reverse();
            if (next.compareTo(res) < 0) {
                res = next;
            }
        }
        return res;
    }
}
