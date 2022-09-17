package leetcode.biweekly_contests.biweekly_88;

public class P_1 {

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        return Math.max(0, Math.min(f(leaveAlice), f(leaveBob)) - Math.max(f(arriveAlice), f(arriveBob)) + 1);
    }

    private static int f(String w) {
        final int[] d = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int res = 0;
        for (int i = 1; i < Integer.parseInt(w.substring(0, 2)); i++) {
            res += d[i - 1];
        }
        return res + Integer.parseInt(w.substring(3));
    }
}
