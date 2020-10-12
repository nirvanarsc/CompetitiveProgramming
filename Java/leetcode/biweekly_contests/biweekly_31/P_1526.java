package leetcode.biweekly_contests.biweekly_31;

public class P_1526 {

    public int minNumberOperations(int[] target) {
        int res = 0;
        for (int i = 0; i < target.length; i++) {
            final int next = i == target.length - 1 ? 0 : target[i + 1];
            res += Math.max(0, target[i] - next);
        }
        return res;
    }
}
