package leetcode.weekly_contests.weekly_100_199.weekly_136;

public class P_1041 {

    private static final int[][] DIRS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    static int curr;

    public boolean isRobotBounded(String instructions) {
        curr = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < 4; i++) {
            for (char c : instructions.toCharArray()) {
                if (c == 'G') {
                    x += DIRS[curr][0];
                    y += DIRS[curr][1];
                } else if (c == 'L') {
                    curr = (curr + 1) % 4;
                } else {
                    curr = (curr + 3) % 4;
                }
            }
        }
        return x == 0 && y == 0;
    }
}
