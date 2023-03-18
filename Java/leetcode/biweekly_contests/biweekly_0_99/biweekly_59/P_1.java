package leetcode.biweekly_contests.biweekly_0_99.biweekly_59;

public class P_1 {

    public int minTimeToType(String word) {
        char curr = 'a';
        int res = 0;
        for (char c : word.toCharArray()) {
            final int d = Math.abs(c - curr);
            res += 1 + Math.min(d, 26 - d);
            curr = c;
        }
        return res;
    }
}
