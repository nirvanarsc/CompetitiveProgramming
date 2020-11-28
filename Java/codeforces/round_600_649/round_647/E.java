package codeforces.round_600_649.round_647;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class E {

    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int k = in.nextInt();
            in.nextLine();
            final int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            in.nextLine();
            Arrays.sort(arr);
            System.out.println(dfs(arr, n, k));
        }
    }

    private static long modpow(long a, long n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            n /= 2;
        }
        return res;
    }

    public static long dfs(int[] num, int n, int k) {
        long res = 0;
        Map<Integer, Long> map = new HashMap<>();
        map.put(num[0], modpow(k, num[0]));
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(num[i])) {
                map.put(num[i], (map.get(num[i - 1]) * modpow(k, num[i] - num[i - 1])) % MOD);
            }
            if (res > 0) {
                res -= map.get(num[i]);
            } else {
                res += map.get(num[i]);
            }
        }
        System.out.println(map);
        return Math.abs(res);
    }
}
