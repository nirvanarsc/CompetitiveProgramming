public final class N_thTribonacciNumber {

    public static void main(String[] args) {
        System.out.println(tribonacci(4));
        System.out.println(tribonacci(25));
    }

    public static int tribonacci(int n) {
        if (n < 2) {
            return n;
        }

        int a = 0;
        int b = 1;
        int c = 1;

        for (int i = 3; i <= n; i++) {
            final int next = a + b + c;
            a = b;
            b = c;
            c = next;
        }

        return c;
    }

    private N_thTribonacciNumber() {}
}
