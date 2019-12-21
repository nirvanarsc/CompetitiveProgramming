package easy;

public final class P_202 {

    public static boolean isHappy(int n) {
        int slow = n, fast = n;

        do {
            slow = f(slow);
            fast = f(f(fast));
            if (slow == 1 || fast == 1) {
                return true;
            }
        } while (slow != fast);

        return false;
    }

    private static int f(int n) {
        int res = 0;
        while (n != 0) {
            final int i = n % 10;
            res += i * i;
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(7));
    }

    private P_202() {}
}
