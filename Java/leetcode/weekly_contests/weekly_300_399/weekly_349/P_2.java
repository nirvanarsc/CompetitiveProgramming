package leetcode.weekly_contests.weekly_300_399.weekly_349;

public class P_2 {

    public String smallestString(String s) {
        final char[] w = s.toCharArray();
        final int n = w.length;
        int i = 0;
        while (i < n && w[i] == 'a') {
            i++;
        }
        if (i == n) {
            w[n - 1] = 'z';
            return new String(w);
        }
        while (i < n && w[i] != 'a') {
            w[i++]--;
        }
        return new String(w);
    }
}
