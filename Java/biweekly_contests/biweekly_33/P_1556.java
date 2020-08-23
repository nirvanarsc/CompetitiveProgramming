package biweekly_contests.biweekly_33;

public class P_1556 {

    public String thousandSeparator(int n) {
        final String s = String.valueOf(n);
        final StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1, j = 0; i >= 0; i--, j++) {
            if (j == 3) {
                sb.append('.');
                j = 0;
            }
            sb.append(s.charAt(i));
        }
        return sb.reverse().toString();
    }
}
