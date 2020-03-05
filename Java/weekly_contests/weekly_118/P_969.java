package weekly_contests.weekly_118;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_969 {

    public List<Integer> pancakeSort(int[] A) {
        final List<Integer> list = new ArrayList<>();
        for (int end = A.length - 1; end >= 0; end--) {
            final int largest = findLargest(A, end);
            if (largest != end) {
                flip(A, 0, largest);
                flip(A, 0, end);
                list.add(largest + 1);
                list.add(end + 1);
            }
        }
        return list;
    }

    private static int findLargest(int[] A, int lastIdx) {
        int max = Integer.MIN_VALUE, index = 0;
        for (int i = 0; i <= lastIdx; i++) {
            if (A[i] > max) {
                max = A[i];
                index = i;
            }
        }
        return index;
    }

    private static void flip(int[] A, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            final int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }
}
