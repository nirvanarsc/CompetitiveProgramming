package leetcode.weekly_contests.weekly_160;

import java.util.List;

public class P_1239 {

    public int maxLength(List<String> arr) {
        final int[] res = { 0 };
        recurse(arr, 0, "", res);
        return res[0];
    }

    private static void recurse(List<String> arr, int i, String s, int[] res) {
        if (i == arr.size()) {
            return;
        }

        for (int k = i; k < arr.size(); k++) {
            if (isUnique(s + arr.get(k))) {
                res[0] = Math.max(res[0], (s + arr.get(k)).length());
                recurse(arr, k + 1, s + arr.get(k), res);
            }
        }
    }

    private static boolean isUnique(String s) {
        int map = 0;
        for (char c : s.toCharArray()) {
            if ((map & (1 << (c - 'a'))) != 0) {
                return false;
            }
            map |= 1 << (c - 'a');
        }
        return true;
    }
}
