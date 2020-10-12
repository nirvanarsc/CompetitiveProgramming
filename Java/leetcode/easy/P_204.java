package leetcode.easy;

public class P_204 {

    public int countPrimes(int n) {
        final boolean[] seen = new boolean[n + 1];
        int res = 0;
        for (int i = 2; i * i < n; i++) {
            if (!seen[i]) {
                for (int j = i * i; j <= n; j += i) {
                    seen[j] = true;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            res += seen[i] ? 0 : 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new P_204().countPrimes(10));
    }
}
