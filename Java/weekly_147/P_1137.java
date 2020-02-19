package weekly_147;

public class P_1137 {

    public int tribonacci(int n) {
        if (n < 2) { return n; }
        int a = 0;
        int b = 1;
        int c = 1;
        for (int i = 3; i <= n; i++) {
            final int d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }
}
