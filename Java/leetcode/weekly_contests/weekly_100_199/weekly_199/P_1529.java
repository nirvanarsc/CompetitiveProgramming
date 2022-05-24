package leetcode.weekly_contests.weekly_100_199.weekly_199;

public class P_1529 {

    public int minFlips(String target) {
        int res = 0;
        for (int i = 1; i < target.length(); i++) {
            if (target.charAt(i) != target.charAt(i - 1)) {
                res++;
            }
        }
        return res + (target.charAt(0) == '1' ? 1 : 0);
    }
}
