package aoc;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public final class P_13_2 {

    // https://cp-algorithms.com/algebra/chinese-remainder-theorem.html
    private static BigInteger[] bezout(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            return new BigInteger[] { BigInteger.ONE, BigInteger.ZERO };
        }
        final BigInteger[] res = bezout(b, a.mod(b));
        return new BigInteger[] { res[1], res[0].subtract(a.divide(b).multiply(res[1])) };
    }

    private static BigInteger modInverse(BigInteger res, BigInteger mod) {
        return res.mod(mod).add(mod).mod(mod);
    }

    private static BigInteger f(BigInteger[] num, BigInteger[] rem, int n) {
        BigInteger prod = BigInteger.valueOf(1);
        for (int i = 0; i < n; i++) {
            prod = prod.multiply(num[i]);
        }
        BigInteger result = BigInteger.valueOf(0);
        for (int i = 0; i < n; i++) {
            final BigInteger pp = prod.divide(num[i]);
            result = result.add(rem[i].multiply(modInverse(bezout(pp, num[i])[0], num[i])).multiply(pp));
        }
        return result.mod(prod);
    }

    private static BigInteger solve(String input) {
        final List<Long> nums = new ArrayList<>();
        final List<Long> rem = new ArrayList<>();
        final String[] split = input.split(",");
        for (int i = 0; i < split.length; i++) {
            if ("x".equals(split[i])) {
                continue;
            }
            final long curr = Long.parseLong(split[i]);
            nums.add(curr);
            rem.add((curr - i) % curr);
        }
        final BigInteger[] n = nums.stream().map(BigInteger::valueOf).toArray(BigInteger[]::new);
        final BigInteger[] r = rem.stream().map(BigInteger::valueOf).toArray(BigInteger[]::new);
        return f(n, r, n.length);
    }

    public static void main(String[] args) {
        final String in1 = "17,x,13,19";
        final String in2 = "41,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,37,x,x,x,x,"
                           + "x,659,x,x,x,x,x,x,x,23,x,x,x,x,13,x,x,x,x,x,19,x,x,x,x,x,x,x,x,x,29,x,937,x,x,x,"
                           + "x,x,x,x,x,x,x,x,x,x,x,x,x,17";

        System.out.println(solve(in1));
        System.out.println(solve(in2));
    }
}
