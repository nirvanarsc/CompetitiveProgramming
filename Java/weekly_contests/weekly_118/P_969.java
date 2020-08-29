package weekly_contests.weekly_118;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_969 {

    public List<Integer> pancakeSort(int[] A) {
        final List<Integer> res = new ArrayList<>();
        for (int curr = A.length; curr > 0; curr--) {
            final int maxIdx = indexOf(A, curr);
            if (maxIdx == A[maxIdx - 1]) {
                continue;
            }
            res.add(maxIdx);
            res.add(curr);
            reverse(A, 0, maxIdx - 1);
            reverse(A, 0, curr - 1);
        }
        return res;
    }

    private static int indexOf(int[] arr, int target) {
        for (int i = 0; true; i++) {
            if (arr[i] == target) {
                return i + 1;
            }
        }
    }

    private static void reverse(int[] arr, int from, int to) {
        for (int i = from; 2 * i < to + from; i++) {
            final int temp = arr[i];
            arr[i] = arr[to + from - i];
            arr[to + from - i] = temp;
        }
    }
}
