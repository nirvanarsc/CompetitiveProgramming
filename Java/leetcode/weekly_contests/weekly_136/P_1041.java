package leetcode.weekly_contests.weekly_136;

public class P_1041 {

    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, dir = 0;
        for (int i = 0; i < instructions.length() * 4; i++) {
            final char c = instructions.charAt(i % instructions.length());
            if (c == 'G') {
                switch (dir) {
                    case 0: y += 1;break;
                    case 1: x += 1;break;
                    case 2: y -= 1;break;
                    case 3: x -= 1;break;
                }
            } else if (c == 'L') {
                dir = (4 + dir - 1) % 4;
            } else {
                dir = (dir + 1) % 4;
            }
        }
        return x == 0 && y == 0;
    }
}
