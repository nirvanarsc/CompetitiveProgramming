package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class P_166 {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        final boolean sign = numerator > 0 == denominator > 0;
        final long dividend = Math.abs(Long.valueOf(numerator));
        final long divisor = Math.abs(Long.valueOf(denominator));
        final StringBuilder sb = new StringBuilder();
        if (!sign) {
            sb.append('-');
        }
        sb.append(dividend / divisor);
        long r = dividend % divisor;
        if (r == 0) {
            return sb.toString();
        }
        sb.append('.');
        final Map<Long, Integer> map = new HashMap<>();
        while (r > 0) {
            if (map.containsKey(r)) {
                sb.insert((int) map.get(r), '(');
                sb.append(')');
                break;
            }
            map.put(r, sb.length());
            r *= 10;
            sb.append(r / divisor);
            r %= divisor;
        }
        return sb.toString();
    }
}
