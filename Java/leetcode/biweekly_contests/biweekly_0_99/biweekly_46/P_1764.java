package leetcode.biweekly_contests.biweekly_0_99.biweekly_46;

public class P_1764 {

    public boolean canChoose(int[][] groups, int[] nums) {
        int from = 0;
        int matched = 0;
        for (int[] g : groups) {
            for (int i = from; i < nums.length; i++) {
                if (nums[i] == g[0]) {
                    final int r = 0;
                    boolean ok = true;
                    for (int k = 0; k < g.length; k++) {
                        if (i + k >= nums.length || nums[i + k] != g[r + k]) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) {
                        from = i + g.length;
                        matched++;
                        break;
                    }
                }
            }
        }
        return matched == groups.length;
    }
}
