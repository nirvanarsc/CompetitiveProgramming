package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

public final class P_60 {

    public static String getPermutation(int n, int k) {
        final List<Integer> list = new LinkedList<>();
        final StringBuilder sb = new StringBuilder();
        final int[] fact = new int[n];
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        fact[0] = 1;
        for (int i = 1; i < n; i++) { fact[i] = i * fact[i - 1]; }
        k -= 1;
        for (int i = n; i > 0; i--) {
            sb.append(list.remove(k / fact[i - 1]));
            k %= fact[i - 1];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 9));
        System.out.println(getPermutation(2, 2));
        System.out.println(getPermutation(1, 1));
        System.out.println(getPermutation(3, 1));
        System.out.println(getPermutation(3, 2));
        System.out.println(getPermutation(3, 3));
        System.out.println(getPermutation(3, 4));
        System.out.println(getPermutation(3, 5));
        System.out.println(getPermutation(3, 6));
    }

    private P_60() {}
}
