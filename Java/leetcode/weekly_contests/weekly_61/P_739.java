package leetcode.weekly_contests.weekly_61;

public class P_739 {

    public int[] dailyTemperatures(int[] temperatures) {
        final int n = temperatures.length;
        final int[] stack = new int[n];
        final int[] res = new int[n];
        int stackIdx = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (stackIdx > 0 && temperatures[i] >= temperatures[stack[stackIdx - 1]]) {
                stackIdx--;
            }
            res[i] = stackIdx == 0 ? 0 : stack[stackIdx - 1] - i;
            stack[stackIdx++] = i;
        }
        return res;
    }
}
