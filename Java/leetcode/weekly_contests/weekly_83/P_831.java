package leetcode.weekly_contests.weekly_83;

public class P_831 {

    @SuppressWarnings({ "DynamicRegexReplaceableByCompiledPattern", "MethodParameterNamingConvention" })
    public String maskPII(String S) {
        final String[] country = { "", "+*-", "+**-", "+***-" };
        final int at = S.indexOf('@');
        if (at > 0) {
            S = S.toLowerCase();
            return (S.charAt(0) + "*****" + S.substring(at - 1)).toLowerCase();
        }
        S = S.replaceAll("[^0-9]", "");
        return country[S.length() - 10] + "***-***-" + S.substring(S.length() - 4);
    }
}
