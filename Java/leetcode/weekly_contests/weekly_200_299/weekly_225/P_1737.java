package leetcode.weekly_contests.weekly_200_299.weekly_225;

public class P_1737 {

    public int minCharacters(String a, String b) {
        return Math.min(Math.min(f1(a, b), f1(b, a)), f2(a, b));
    }

    private static int f1(String a, String b) {
        int res = (int) 1e9;
        for (int i = 1; i < 26; i++) {
            int count = 0;
            for (char c : a.toCharArray()) {
                if ((c - 'a') >= i) { count++; }
            }
            for (char c : b.toCharArray()) {
                if ((c - 'a') < i) { count++; }
            }
            res = Math.min(res, count);
        }
        return res;
    }

    private static int f2(String a, String b) {
        final int[] map = new int[26];
        for (char c : a.toCharArray()) { map[c - 'a']++; }
        for (char c : b.toCharArray()) { map[c - 'a']++; }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res = Math.max(res, map[i]);
        }
        return a.length() + b.length() - res;
    }
}
