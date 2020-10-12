package leetcode.biweekly_contests.biweekly_24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_1414 {

    public int findMinFibonacciNumbers(int k) {
        final List<Integer> fibNumbers = new ArrayList<>(Arrays.asList(1, 1));
        getFib(fibNumbers, k);
        int count = 0, j = fibNumbers.size() - 1;
        while (k > 0) {
            count += k / fibNumbers.get(j);
            k %= fibNumbers.get(j);
            j--;
        }
        return count;
    }

    public static void getFib(List<Integer> fibNumbers, int k) {
        for (int i = 2; fibNumbers.get(i - 1) + fibNumbers.get(i - 2) <= k; i++) {
            fibNumbers.add(fibNumbers.get(i - 1) + fibNumbers.get(i - 2));
        }
    }
}
