package weekly_contests.weekly_179;

public class P_1374 {

    public String generateTheString(int n) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            sb.append('a');
        }
        sb.append(n % 2 != 0 ? 'a' : 'b');
        return sb.toString();
    }
}
