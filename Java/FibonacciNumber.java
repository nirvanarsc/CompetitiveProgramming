import java.util.HashMap;
import java.util.Map;

public final class FibonacciNumber {

    public static void main(String[] args) {
        System.out.println(fib(30));
        System.out.println(fib2(30));
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int curr = 1;
        int prev = 0;
        int temp;
        for (int i = n - 2; i > 0; i--) {
            temp = prev;
            prev = curr;
            curr = temp + curr;
        }
        return prev + curr;
    }

    public static int fib2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        for (int i = 2; i <= n; i++) {
            map.put(i, map.get(i - 2) + map.get(i - 1));
        }
        return map.get(n);
    }

    private FibonacciNumber() {}
}
