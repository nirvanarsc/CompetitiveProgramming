package medium;

import java.util.Arrays;
import java.util.stream.Collectors;

public class P_179 {

    public String largestNumber(int[] nums) {
        final String res = Arrays.stream(nums)
                                 .mapToObj(String::valueOf)
                                 .sorted((a, b) -> (b + a).compareTo(a + b))
                                 .collect(Collectors.joining());
        return res.charAt(0) == '0' ? "0" : res;
    }
}
