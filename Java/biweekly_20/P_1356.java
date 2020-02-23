package biweekly_20;

import java.util.Arrays;

public class P_1356 {

    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
                     .boxed()
                     .sorted((a, b) -> {
                         int bitCountA = Integer.bitCount(a);
                         int bitCountB = Integer.bitCount(b);
                         if (bitCountA == bitCountB) {
                             return Integer.compare(a, b);
                         }
                         return Integer.compare(bitCountA, bitCountB);
                     })
                     .mapToInt(i -> i)
                     .toArray();
    }
}
