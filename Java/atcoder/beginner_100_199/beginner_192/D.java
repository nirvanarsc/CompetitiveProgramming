package atcoder.beginner_100_199.beginner_192;

import java.math.BigInteger;
import java.util.Scanner;

public class D {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        final Scanner sc = new Scanner(System.in);
        final String string = sc.next();
        final BigInteger m = sc.nextBigInteger();
        int d = 0;
        for (int i = 0; i < string.length(); i++) {
            d = Math.max(d, string.charAt(i) - '0');
        }
        long l = d + 1;
        long r = (long) 1e18;
        final BigInteger x = new BigInteger(string);
        if (string.length() == 1) {
            if (x.longValue() <= m.longValue()) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            return;
        }
        long ans = 0;
        while (l < r) {
            final long mid = (l + r + 1) / 2;
            final BigInteger d1 = BigInteger.valueOf(mid);
            BigInteger res = BigInteger.valueOf(0);
            boolean ok = true;
            for (int i = 0; i < string.length(); i++) {
                res = res.multiply(d1).add(BigInteger.valueOf(string.charAt(i) - '0'));
                if (res.compareTo(m) > 0) {
                    ok = false;
                    break;
                }
            }
            if (!ok) { r = mid - 1; } else {l = mid;}
        }
        System.out.println(Math.max(0, l - d));
    }

}

