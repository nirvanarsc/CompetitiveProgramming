package leetcode.weekly_contests.weekly_118;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_972 {

    public boolean isRationalEqual(String S, String T) {
        return Double.compare(f(S), f(T)) == 0;
    }

    public double f(String S) {
        final int i = S.indexOf('(');
        if (i > 0) {
            final StringBuilder base = new StringBuilder(S.substring(0, i));
            final String rep = S.substring(i + 1, S.length() - 1);
            for (int j = 0; j < 20; ++j) { base.append(rep); }
            return Double.valueOf(base.toString());
        }
        return Double.valueOf(S);
    }
}
