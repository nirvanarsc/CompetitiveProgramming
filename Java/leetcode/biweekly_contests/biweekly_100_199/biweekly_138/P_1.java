package leetcode.biweekly_contests.biweekly_100_199.biweekly_138;

public class P_1 {

    public int generateKey(int num1, int num2, int num3) {
        int res = 0;
        for (int p : new int[] { 1000, 100, 10, 1 }) {
            int f = 10;
            for (int u : new int[] { num1, num2, num3 }) {
                f = Math.min(f, (u / p) % 10);
            }
            res = res * 10 + f;
        }
        return res;
    }
}
