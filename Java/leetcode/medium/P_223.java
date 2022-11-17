package leetcode.medium;

public class P_223 {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int curr = (Math.abs(ax1 - ax2) * Math.abs(ay1 - ay2)) + (Math.abs(bx1 - bx2) * Math.abs(by1 - by2));
        final int m = Math.max(ax1, bx1);
        final int n = Math.max(ay1, by1);
        final int p = Math.min(ax2, bx2);
        final int q = Math.min(ay2, by2);
        if (m < p && n < q) {
            curr -= (p - m) * (q - n);
        }
        return curr;
    }
}
