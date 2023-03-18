package leetcode.biweekly_contests.biweekly_0_99.biweekly_23;

public class P_1401 {

    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        final int deltaX = x_center - Math.max(x1, Math.min(x_center, x2));
        final int deltaY = y_center - Math.max(y1, Math.min(y_center, y2));
        return (deltaX * deltaX + deltaY * deltaY) <= (radius * radius);
    }
}
