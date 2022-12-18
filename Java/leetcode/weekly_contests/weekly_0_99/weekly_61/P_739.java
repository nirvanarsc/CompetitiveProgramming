package leetcode.weekly_contests.weekly_0_99.weekly_61;

public class P_739 {

    public int[] dailyTemperatures(int[] temperatures) {
        final int n = temperatures.length;
        final int[] stack = new int[n + 1];
        final int[] res = new int[n];
        int idx = 1;
        for (int i = n - 1; i >= 0; i--) {
            while (idx > 1 && temperatures[i] >= temperatures[stack[idx - 1]]) {
                idx--;
            }
            res[i] = Math.max(0, stack[idx - 1] - i);
            stack[idx++] = i;
        }
        return res;
    }
}
