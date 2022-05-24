package leetcode.weekly_contests.weekly_0_99.weekly_28;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P_553 {

    Deque<double[]> res;

    public String optimalDivisionBF(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        final double[] max = { 0 };
        final double[] doubles = Arrays.stream(nums).mapToDouble(i -> i).toArray();
        recurse(doubles, max, new ArrayDeque<>());
        final StringBuilder sb = new StringBuilder();
        double prev = -1.0;
        while (!res.isEmpty()) {
            final double[] curr = res.removeLast();
            if (Double.compare(prev, -1.0) == 0) {
                sb.append((int) curr[0]);
                sb.append('/');
                sb.append((int) curr[1]);
            } else if (Double.compare(prev, curr[0]) == 0) {
                sb.append('/');
                sb.append((int) curr[1]);
            } else if (Double.compare(prev, curr[1]) == 0) {
                sb.insert(0, (int) curr[0] + "/(");
                sb.append(')');
            }
            prev = curr[0] / curr[1];
        }
        return sb.toString();
    }

    private void recurse(double[] sum, double[] max, Deque<double[]> ops) {
        if (sum.length == 1) {
            if (max[0] < sum[0]) {
                max[0] = sum[0];
                res = new ArrayDeque<>(ops);
            }
            return;
        }
        for (int i = 0; i < sum.length - 1; i++) {
            final double[] next = new double[sum.length - 1];
            System.arraycopy(sum, 0, next, 0, i);
            next[i] = sum[i] / sum[i + 1];
            System.arraycopy(sum, i + 2, next, i + 1, sum.length - 2 - i);
            ops.addFirst(new double[] { sum[i], sum[i + 1] });
            recurse(next, max, ops);
            ops.removeFirst();
        }
    }

    public String optimalDivision(int[] nums) {
        if (nums.length == 1) { return String.valueOf(nums[0]); }
        if (nums.length == 2) { return nums[0] + "/" + nums[1]; }
        final StringBuilder res = new StringBuilder(nums[0] + "/(" + nums[1]);
        for (int i = 2; i < nums.length; i++) {
            res.append("/" + nums[i]);
        }
        res.append(')');
        return res.toString();
    }
}
