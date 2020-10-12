package leetcode.weekly_contests.weekly_93;

import java.util.Arrays;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_869 {

    public boolean reorderedPowerOf2(int N) {
        final int[] A = cnt(N);
        for (int i = 0; i < Integer.SIZE; ++i) {
            if (Arrays.equals(A, cnt(1 << i))) {
                return true;
            }
        }
        return false;
    }

    private static int[] cnt(int num) {
        final int[] res = new int[10];
        while (num > 0) {
            ++res[num % 10];
            num /= 10;
        }
        return res;
    }

    public boolean reorderedPowerOf2BF(int N) {
        return permute(String.valueOf(N).toCharArray(), 0);
    }

    private static boolean permute(char[] arr, int i) {
        if (i == arr.length && arr[0] != '0') {
            final int temp = Integer.parseInt(new String(arr));
            return (temp & temp - 1) == 0;
        }
        for (int j = i; j < arr.length; j++) {
            swap(arr, i, j);
            if (permute(arr, i + 1)) {
                return true;
            }
            swap(arr, j, i);
        }
        return false;
    }

    private static void swap(char[] arr, int i, int j) {
        final char t1 = arr[i];
        arr[i] = arr[j];
        arr[j] = t1;
    }
}
