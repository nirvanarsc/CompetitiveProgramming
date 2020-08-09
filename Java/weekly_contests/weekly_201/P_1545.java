package weekly_contests.weekly_201;

public class P_1545 {

    public char findKthBit(int n, int k) {
        final String[] calc = new String[20];
        calc[0] = "0";
        for (int i = 1; i < calc.length; i++) {
            final String prev = calc[i - 1];
            final StringBuilder next = new StringBuilder(prev);
            next.append(1);
            for (int j = prev.length() - 1; j >= 0; j--) {
                next.append(prev.charAt(j) == '0' ? 1 : 0);
            }
            calc[i] = next.toString();
        }
        return calc[n - 1].charAt(k - 1);
    }
}
