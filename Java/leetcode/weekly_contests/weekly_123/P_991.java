package leetcode.weekly_contests.weekly_123;

public class P_991 {

    public int brokenCalcRecursive(int x, int y) {
        if (x >= y) {
            return x - y;
        }

        return 1 + y % 2 + brokenCalc(x, (y + 1) >> 1);
    }

    public int brokenCalc(int x, int y) {
        int count = 0;
        while (y != x) {
            if (x >= y) {
                return (x - y) + count;
            }
            if (y % 2 == 0) {
                y >>= 1;
            } else {
                y++;
            }
            count++;
        }
        return count;
    }
}
