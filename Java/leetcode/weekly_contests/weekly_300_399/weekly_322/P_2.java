package leetcode.weekly_contests.weekly_300_399.weekly_322;

public class P_2 {

    public long dividePlayers(int[] skill) {
        final int n = skill.length;
        int total = 0;
        for (int s : skill) {
            total += s;
        }
        if (total % (n / 2) != 0) {
            return -1;
        }
        final int v = total / (n / 2);
        final int[] seen = new int[1005];
        long res = 0;
        int m = 0;
        for (int s : skill) {
            if (seen[v - s] > 0) {
                seen[v - s]--;
                res += s * (v - s);
                m++;
            } else {
                seen[s]++;
            }
        }
        return 2 * m == n ? res : -1;
    }
}
