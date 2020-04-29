package weekly_contests.weekly_33;

import java.util.stream.Stream;

@SuppressWarnings("DynamicRegexReplaceableByCompiledPattern")
public class P_592 {

    public int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }

    public String fractionAddition(String expression) {
        String res = "0/1";
        for (String frac : expression.split("(?=[-+])")) {
            res = add(res, frac);
        }
        return res;
    }

    public String add(String frac1, String frac2) {
        final int[] f1 = Stream.of(frac1.split("/")).mapToInt(Integer::parseInt).toArray();
        final int[] f2 = Stream.of(frac2.split("/")).mapToInt(Integer::parseInt).toArray();
        int numer = f1[0] * f2[1] + f1[1] * f2[0];
        final int denom = f1[1] * f2[1];
        String sign = "";
        if (numer < 0) {
            sign = "-";
            numer *= -1;
        }
        return sign + numer / gcd(numer, denom) + '/' + denom / gcd(numer, denom);
    }
}
