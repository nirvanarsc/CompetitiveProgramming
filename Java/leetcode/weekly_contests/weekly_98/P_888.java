package leetcode.weekly_contests.weekly_98;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_888 {

    public int[] fairCandySwapBF(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        for (int a : A) { sumA += a; }
        for (int b : B) { sumB += b; }
        for (int val1 : A) {
            for (int val2 : B) {
                if (sumA + 2 * val2 == sumB + 2 * val1) {
                    return new int[] { val1, val2 };
                }
            }
        }
        return new int[] { 0, 0 };
    }

    public int[] fairCandySwap(int[] A, int[] B) {
        final Set<Integer> hash = new HashSet<>();
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        for (int b : B) {
            hash.add(b);
            sum -= b;
        }
        final int diff = sum / 2;
        for (int a : A) {
            if (hash.contains(a - diff)) {
                return new int[] { a, a - diff };
            }
        }
        return new int[] { 0, 0 };
    }
}
