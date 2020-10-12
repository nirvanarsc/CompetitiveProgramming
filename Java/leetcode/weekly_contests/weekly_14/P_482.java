package leetcode.weekly_contests.weekly_14;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_482 {

    public String licenseKeyFormatting(String S, int K) {
        final StringBuilder sb = new StringBuilder(S.replace("-", "").toUpperCase());
        for (int i = sb.length() - K; i > 0; i -= K) {
            sb.insert(i, '-');
        }
        return sb.toString();
    }
}
