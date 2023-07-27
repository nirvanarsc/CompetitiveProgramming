package leetcode.biweekly_contests.biweekly_100_199.biweekly_104;

public class P_1 {

    public int countSeniors(String[] details) {
        int res = 0;
        for (String s : details) {
            res += f(s) > 60 ? 1 : 0;
        }
        return res;
    }

    private static int f(String s) {
        return 10 * (s.charAt(11) - '0') + (s.charAt(12) - '0');
    }
}
