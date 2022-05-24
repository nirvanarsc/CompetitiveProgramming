package leetcode.weekly_contests.weekly_0_99.weekly_75;

public class P_796 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (B + B).contains(A);
    }
}
