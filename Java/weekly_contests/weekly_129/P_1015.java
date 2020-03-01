package weekly_contests.weekly_129;

import java.math.BigInteger;

public class P_1015 {

    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) { return -1; }
        int r = 0;
        for (int N = 1; N <= K; ++N) {
            r = (r * 10 + 1) % K;
            if (r == 0) {
                return N;
            }
        }
        return -1;
    }

    public int smallestRepunitDivByKBF(int K) {
        if (K % 2 == 0 || K % 5 == 0) { return -1; }
        BigInteger start = BigInteger.ONE;
        int res = 1;
        while (true) {
            if (start.mod(BigInteger.valueOf(K)).equals(BigInteger.ZERO)) {
                return res;
            }
            start = start.multiply(BigInteger.TEN).add(BigInteger.ONE);
            res++;
        }
    }
}
