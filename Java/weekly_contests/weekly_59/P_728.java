package weekly_contests.weekly_59;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P_728 {

    @SuppressWarnings("Convert2MethodRef")
    public List<Integer> selfDividingNumbers(int left, int right) {
        return IntStream.rangeClosed(left, right)
                        .boxed()
                        .filter(i -> check(i))
                        .collect(Collectors.toList());
    }

    private static boolean check(int num) {
        int t = num;
        while (t > 0) {
            if (t % 10 == 0 || num % (t % 10) != 0) {
                return false;
            }
            t /= 10;
        }
        return true;
    }
}
