package leetcode.medium;

public final class P_50 {

    public static double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            n += 2;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        }
        return x * myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        System.out.println(myPow(0.5, -4));
    }

    private P_50() {}
}
