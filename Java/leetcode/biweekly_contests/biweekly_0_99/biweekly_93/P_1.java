package leetcode.biweekly_contests.biweekly_0_99.biweekly_93;

public class P_1 {

    public int maximumValue(String[] strs) {
        int res = 0;
        for (String s : strs) {
            res = Math.max(res, f(s));
        }
        return res;
    }

    private static int f(String s) {
        int res;
        try {
            res = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            res = s.length();
        }
        return res;
    }
}
