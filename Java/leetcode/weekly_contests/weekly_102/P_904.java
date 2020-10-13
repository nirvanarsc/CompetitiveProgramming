package leetcode.weekly_contests.weekly_102;

public class P_904 {

    public int totalFruit(int[] tree) {
        int j = 0;
        int res = 0;
        final int[] seen = new int[40000];
        int window = 2;
        for (int i = 0; i < tree.length; i++) {
            window -= seen[tree[i]]++ == 0 ? 1 : 0;
            while (window < 0) {
                window += --seen[tree[j++]] == 0 ? 1 : 0;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
