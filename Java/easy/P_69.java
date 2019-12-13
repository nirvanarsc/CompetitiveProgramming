package easy;

public class P_69 {

    public int mySqrt(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }

    public int mySqrtNewton(int x) {
        double a = 1;
        double prev = 0.0;
        while (true) {
            final double curr = 0.5 * (a + x / a);
            if (Math.abs(prev - curr) < 0.00001) {
                return (int) Math.floor(curr);
            }
            prev = curr;
            a = curr;
        }
    }
}
