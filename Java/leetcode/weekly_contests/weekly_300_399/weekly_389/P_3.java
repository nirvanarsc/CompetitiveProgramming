package leetcode.weekly_contests.weekly_300_399.weekly_389;

public class P_3 {

    public int minimumDeletions(String word, int k) {
        final int[] f = new int[26];
        for (char c : word.toCharArray()) {
            f[c - 'a']++;
        }
        int res = (int) 1e9;
        for (int max = 1; max <= word.length(); max++) {
            int curr = 0;
            for (int i = 0; i < 26; i++) {
                if (max - k > f[i]) {
                    curr += f[i];
                } else if (f[i] > max) {
                    curr += f[i] - max;
                }
            }
            res = Math.min(res, curr);
        }
        return res;
    }
}
