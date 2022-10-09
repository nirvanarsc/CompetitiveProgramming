package leetcode.weekly_contests.weekly_300_399.weekly_314;

public class P_2 {

    public int[] findArray(int[] pref) {
        final int n = pref.length;
        final int[] res = new int[n];
        res[0] = pref[0];
        for (int i = 1; i < n; i++) {
            res[i] = pref[i] ^ pref[i - 1];
        }
        return res;
    }
}
