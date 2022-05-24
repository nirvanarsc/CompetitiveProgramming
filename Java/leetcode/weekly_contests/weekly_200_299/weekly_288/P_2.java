package leetcode.weekly_contests.weekly_200_299.weekly_288;

public class P_2 {

    public String minimizeResult(String expression) {
        long min = (long) 9e18;
        String res = "";
        final int p = expression.indexOf('+');
        final String a = expression.substring(0, p);
        final String b = expression.substring(p + 1);
        for (int i = 0; i < a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                final long l1 = i == 0 ? 1 : Long.parseLong(a.substring(0, i));
                final long l2 = Long.parseLong(a.substring(i));
                final long r1 = Long.parseLong(b.substring(0, j));
                final long r2 = j == b.length() ? 1 : Long.parseLong(b.substring(j));
                if (min > l1 * (l2 + r1) * r2) {
                    min = l1 * (l2 + r1) * r2;
                    res = (i == 0 ? "" : l1) + "(" + l2 + '+' + r1 + ')' + (j == b.length() ? "" : r2);
                }
                min = Math.min(min, l1 * (l2 + r1) * r2);
            }
        }
        return res;
    }
}
