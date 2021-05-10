package leetcode.easy;

public class P_204 {

    public int countPrimes(int n) {
        final boolean[] sieve = new boolean[n];
        for (int p = 2; p * p < n; p++) {
            if (!sieve[p]) {
                for (int k = p * p; k < n; k += p) {
                    sieve[k] = true;
                }
            }
        }
        int res = 0;
        for (int p = 2; p < n; p++) {
            if (!sieve[p]) {
                res++;
            }
        }
        return res;
    }
}
