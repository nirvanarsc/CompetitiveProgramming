package leetcode.weekly_contests.weekly_200_299.weekly_295;

public class P_1 {

    public int rearrangeCharacters(String s, String target) {
        final int[] l = new int[26];
        final int[] r = new int[26];
        for (char c : s.toCharArray()) {
            l[c - 'a']++;
        }
        for (char c : target.toCharArray()) {
            r[c - 'a']++;
        }
        int res = (int) 1e9;
        for (int i = 0; i < 26; i++) {
            if (r[i] > 0) {
                res = Math.min(res, l[i] / r[i]);
            }
        }
        return res;
    }
}
