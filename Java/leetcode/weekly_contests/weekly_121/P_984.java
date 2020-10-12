package leetcode.weekly_contests.weekly_121;

public class P_984 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public String strWithout3a3b(int A, int B) {
        final StringBuilder res = new StringBuilder(A + B);
        char a = 'a', b = 'b';
        int i = A, j = B;
        if (B > A) { a = 'b'; b = 'a'; i = B; j = A; }
        while (i-- > 0) {
            res.append(a);
            if (i > j) { res.append(a); --i; }
            if (j-- > 0) { res.append(b); }
        }
        return res.toString();
    }
}
