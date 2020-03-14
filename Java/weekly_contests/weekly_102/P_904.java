package weekly_contests.weekly_102;

public class P_904 {

    public int totalFruit(int[] tree) {
        final int[] map = new int[tree.length];
        int k = 2, i = 0, res = 0;
        for (int j = 0; j < tree.length; j++) {
            k -= map[tree[j]]++ == 0 ? 1 : 0;
            while (k < 0) {
                k += --map[tree[i++]] == 0 ? 1 : 0;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

}
