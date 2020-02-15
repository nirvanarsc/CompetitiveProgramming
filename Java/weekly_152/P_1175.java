package weekly_152;

import java.util.Arrays;
import java.util.List;

public class P_1175 {
    private static final List<Integer> PRIMES = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
                                                              43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);
    private static final int MOD = (int) (1e9 + 7);

    public int numPrimeArrangements(int n) {
        int primes = 0;
        for (int p : PRIMES) {
            if (p <= n) { primes++; }
        }
        long res = 1;
        for (int i = 1; i <= primes; i++) {
            res = (res * i) % MOD;
        }
        for (int i = 1; i <= n - primes; i++) {
            res = (res * i) % MOD;
        }
        return (int) res;
    }
}
