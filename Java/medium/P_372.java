package medium;

public class P_372 {

    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        if (a % MOD == 0) {
            return 0;
        }
        int p = 0;
        for (int num : b) {
            p = (p * 10 + num) % 1140;
        }
        return modPow(a % 1337, p);
    }

    private static int modPow(int a, int n) {
        int res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            n /= 2;
        }
        return res;
    }
}
