package leetcode.weekly_contests.weekly_183;

import java.math.BigInteger;

public class P_1404 {

    public int numSteps(String s) {
        int res = 0, carry = 0;
        for (int i = s.length() - 1; i > 0; --i) {
            if (s.charAt(i) - '0' + carry == 1) {
                carry = 1;
                res += 2;
            } else {
                res += 1;
            }
        }
        return res + carry;
    }

    public int numStepsBigInt(String s) {
        BigInteger b = new BigInteger(s, 2);
        int res = 0;
        while (!b.equals(BigInteger.ONE)) {
            if (b.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)) {
                b = b.add(BigInteger.ONE);
            } else {
                b = b.shiftRight(1);
            }
            res++;
        }
        return res;
    }
}
