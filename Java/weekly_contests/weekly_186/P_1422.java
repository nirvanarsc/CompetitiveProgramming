package weekly_contests.weekly_186;

public class P_1422 {

    public int maxScore(String s) {
        final int n = s.length();
        int c1 = 0;
        for (int i = 0; i < n; i++) {
            c1 += s.charAt(i) == '1' ? 1 : 0;
        }
        int max = 0;
        int c2 = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                c2++;
            } else {
                c1--;
            }
            max = Math.max(max, c1 + c2);
        }
        return max;
    }
}
