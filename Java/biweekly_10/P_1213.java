package biweekly_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_1213 {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        final List<Integer> res = new ArrayList<>();
        for (int num : arr1) {
            final int i1 = Arrays.binarySearch(arr2, num);
            final int i2 = Arrays.binarySearch(arr3, num);
            if (i1 >= 0 && i2 >= 0) {
                res.add(num);
            }
        }
        return res;
    }
}
