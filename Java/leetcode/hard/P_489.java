package leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class P_489 {

    interface Robot {
        boolean move();

        void turnRight();

        void clean();
    }

    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public void cleanRoom(Robot robot) {
        dfs(0, 0, 0, new HashSet<>(), robot);
    }

    public void dfs(int x, int y, int d, Set<String> visited, Robot robot) {
        robot.clean();
        for (int i = 0; i < 4; i++) {
            final int newD = (i + d) % 4;
            final int newX = x + DIRS[newD][0];
            final int newY = y + DIRS[newD][1];
            if (visited.add(newX + "," + newY) && robot.move()) {
                dfs(newX, newY, newD, visited, robot);
            }
            robot.turnRight();
        }
        back(robot);
    }

    public void back(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
