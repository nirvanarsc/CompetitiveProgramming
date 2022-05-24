package leetcode.weekly_contests.weekly_0_99.weekly_65;

public class P_754 {

    private static long sum(int n) {
        return ((long) n * (n + 1)) / 2;
    }

    public int reachNumber(int target) {
        int steps = 0;
        target = Math.abs(target);
        while (sum(steps) < target) {
            steps++;
        }
        if (steps % 4 == 1 || steps % 4 == 2) {
            if (target % 2 == 0) {
                while (steps % 4 != 3) {
                    steps++;
                }
            }
        } else {
            if (target % 2 != 0) {
                while (steps % 4 != 1) {
                    steps++;
                }
            }
        }
        return steps;
    }
}
