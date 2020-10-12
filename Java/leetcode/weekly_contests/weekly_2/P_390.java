package leetcode.weekly_contests.weekly_2;

public class P_390 {

    public int lastRemainingIterative(int n) {
        boolean direction = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (direction || remaining % 2 == 1) {
                head += step;
            }
            remaining >>= 1;
            step <<= 1;
            direction = !direction;
        }
        return head;
    }

    public int lastRemaining(int n) {
        return leftToRight(n);
    }

    private int leftToRight(int n) {
        if (n == 1) {
            return 1;
        }
        return 2 * rightToLeft(n / 2);
    }

    private int rightToLeft(int n) {
        if (n == 1) {
            return 1;
        }
        if (n % 2 == 0) {
            return 2 * leftToRight(n / 2) - 1;
        } else {
            return 2 * leftToRight(n / 2);
        }
    }
}
