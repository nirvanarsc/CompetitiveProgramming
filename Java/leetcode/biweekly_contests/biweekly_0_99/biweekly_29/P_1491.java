package leetcode.biweekly_contests.biweekly_0_99.biweekly_29;

public class P_1491 {

    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int total = 0;
        for (int s : salary) {
            min = Math.min(min, s);
            max = Math.max(max, s);
            total += s;
        }
        total -= min;
        total -= max;
        final double n = salary.length - 2;
        return total / n;
    }
}
