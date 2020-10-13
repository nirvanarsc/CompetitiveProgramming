package leetcode.weekly_contests.weekly_102;

import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_905 {

    public int[] sortArrayByParitySort(int[] A) {
        return Arrays.stream(A)
                     .boxed()
                     .sorted(Comparator.comparingInt(a -> a % 2))
                     .mapToInt(Integer::intValue)
                     .toArray();
    }

    public int[] sortArrayByParity(int[] A) {
        for (int i = 0, j = 0; j < A.length; j++) {
            if (A[j] % 2 == 0) {
                final int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }
}
