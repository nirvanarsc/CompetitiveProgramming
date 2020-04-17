package weekly_contests.weekly_52;

public class P_686 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int repeatedStringMatch(String A, String B) {
        int k = B.length() / A.length();
        if (k * A.length() != B.length()) {
            k++;
        }
        final String repeated = A.repeat(k);
        if (repeated.contains(B)) {
            return k;
        }
        if ((repeated + A).contains(B)) {
            return k + 1;
        }
        return -1;
    }
}
