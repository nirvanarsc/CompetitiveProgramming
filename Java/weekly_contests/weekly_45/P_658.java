package weekly_contests.weekly_45;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P_658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0, hi = arr.length - k;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (arr[mid] + arr[mid + k] < 2 * x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return Arrays.stream(arr, lo, lo + k)
                     .boxed()
                     .collect(Collectors.toList());
    }
}
