package leetcode.weekly_contests.weekly_0_99.weekly_67;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class P_762 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int countPrimeSetBits(int L, int R) {
        final Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));
        return IntStream.rangeClosed(L, R)
                        .map(i -> primes.contains(Integer.bitCount(i)) ? 1 : 0)
                        .reduce(0, Integer::sum);
    }
}
