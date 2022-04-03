package leetcode.weekly_contests.weekly_287;

public class P_1 {

    public int convertTime(String current, String correct) {
        final int h = Integer.parseInt(correct.substring(0, 2)) - Integer.parseInt(current.substring(0, 2));
        final int m = Integer.parseInt(correct.substring(3)) - Integer.parseInt(current.substring(3));
        int d = h * 60 + m;
        int res = 0;
        for (int num : new int[] { 60, 15, 5, 1 }) {
            final int t = d / num;
            d -= t * num;
            res += t;
        }
        return res;
    }
}
