package leetcode.weekly_contests.weekly_154;

public class P_1189 {

    public int maxNumberOfBalloons(String text) {
        final int[] f = new int[26];
        for (char c : text.toCharArray()) {
            f[c - 'a']++;
        }
        f['l' - 'a'] /= 2;
        f['o' - 'a'] /= 2;
        int res = (int) 1e9;
        for (char c : "balloon".toCharArray()) {
            res = Math.min(res, f[c - 'a']);
        }
        return res;
    }
}
