package easy;

@SuppressWarnings("MethodParameterNamingConvention")
public final class P_509 {

    public int fib(int N) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < N; i++) {
            final int next = a + b;
            a = b;
            b = next;
        }
        return a;
    }

    // https://en.wikipedia.org/wiki/Fibonacci_number#Closed-form_expression
    public int fibClosedForm(int N) {
        final double sqrt5 = 2.23606797749979;
        final double goldenRatio = (1 + sqrt5) / 2;
        return (int) Math.round(Math.pow(goldenRatio, N) / sqrt5);
    }
}
