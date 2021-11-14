package leetcode.biweekly_contests.biweekly_65;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_2 {

    class Robot {

        String[] dirs = { "East", "North", "West", "South" };
        int n;
        int m;
        int dir;
        int x;
        int y;

        public Robot(int width, int height) {
            n = height;
            m = width;
            dir = 0;
            x = 0;
            y = 0;
        }

        public void move(int num) {
            num %= 2 * (n + m - 2);
            if (num == 0) {
                if (x == 0 && y == 0) {
                    dir = 3;
                } else if (x == 0 && y == m - 1) {
                    dir = 0;
                } else if (x == n - 1 && y == m - 1) {
                    dir = 1;
                } else if (x == n - 1 && y == 0) {
                    dir = 2;
                }
            }
            int maxMove;
            int move;
            while (num > 0) {
                switch (dir) {
                    case 0:
                        maxMove = m - y - 1;
                        if (maxMove == 0) {
                            dir++;
                        } else {
                            move = Math.min(num, maxMove);
                            y += move;
                            num -= move;
                        }
                        break;
                    case 1:
                        maxMove = n - x - 1;
                        if (maxMove == 0) {
                            dir++;
                        } else {
                            move = Math.min(num, maxMove);
                            x += move;
                            num -= move;
                        }
                        break;
                    case 2:
                        maxMove = y;
                        if (maxMove == 0) {
                            dir++;
                        } else {
                            move = Math.min(num, maxMove);
                            y -= move;
                            num -= move;
                        }
                        break;
                    case 3:
                        maxMove = x;
                        if (maxMove == 0) {
                            dir = 0;
                        } else {
                            move = Math.min(num, maxMove);
                            x -= move;
                            num -= move;
                        }
                        break;
                }
            }
        }

        public int[] getPos() {
            return new int[] { y, x };
        }

        public String getDir() {
            return dirs[dir];
        }
    }
}
