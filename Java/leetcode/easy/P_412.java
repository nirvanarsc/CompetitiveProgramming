package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class P_412 {

    public List<String> fizzBuzz(int n) {
        final List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            final StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (sb.length() == 0) {
                sb.append(i);
            }
            res.add(sb.toString());
        }
        return res;
    }
}
