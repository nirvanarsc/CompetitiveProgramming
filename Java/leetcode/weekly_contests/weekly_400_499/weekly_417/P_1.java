package leetcode.weekly_contests.weekly_400_499.weekly_417;

public class P_1 {

    public char kthCharacter(int k) {
        String curr = "a";
        while (curr.length() < k) {
            curr = f(curr);
        }
        return curr.charAt(k - 1);
    }

    private static String f(String w) {
        return w + next(w);
    }

    private static String next(String w) {
        final int n = w.length();
        final char[] res = new char[n];
        for (int i = 0; i < n; i++) {
            res[i] = (char) ('a' + (w.charAt(i) - 'a' + 1) % 26);
        }
        return new String(res);
    }
}
