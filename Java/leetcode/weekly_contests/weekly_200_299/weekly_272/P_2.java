package leetcode.weekly_contests.weekly_200_299.weekly_272;

public class P_2 {

    public String addSpaces(String s, int[] spaces) {
        final StringBuilder sb = new StringBuilder();
        final char[] w = s.toCharArray();
        final int n = s.length();
        final int m = spaces.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (j < m && spaces[j] == i) {
                j++;
                sb.append(' ');
            }
            sb.append(w[i]);
        }
        return sb.toString();
    }
}
