package leetcode.weekly_contests.weekly_100_199.weekly_102;

public class P_904 {

    public int totalFruit(int[] tree) {
        final int n = tree.length;
        final int[] seen = new int[n];
        int j = 0;
        int res = 0;
        int curr = 2;
        for (int i = 0; i < n; i++) {
            curr -= seen[tree[i]]++ == 0 ? 1 : 0;
            while (curr < 0) {
                curr += --seen[tree[j++]] == 0 ? 1 : 0;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
