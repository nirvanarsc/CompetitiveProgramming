package leetcode.weekly_contests.weekly_300_399.weekly_335;

public class P_1 {

    public int passThePillow(int n, int time) {
        final int loop = 2 * (n - 1);
        time %= loop;
        int idx = 1;
        while (idx < n && time > 0) {
            idx++;
            time--;
        }
        while (idx > 1 && time > 0) {
            idx--;
            time--;
        }
        return idx;
    }
}
