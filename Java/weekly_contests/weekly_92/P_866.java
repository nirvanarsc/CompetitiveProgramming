package weekly_contests.weekly_92;

import java.util.Set;
import java.util.TreeSet;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_866 {

    //All even palindromes can be divided by 11
    public int primePalindrome(int N) {
        if (8 <= N && N <= 11) {
            return 11;
        }
        for (int x = 1; x < 100000; x++) {
            final String s = Integer.toString(x);
            final String r = new StringBuilder(s).reverse().toString();
            final int y = Integer.parseInt(s + r.substring(1));
            if (y >= N && isPrime(y)) {
                return y;
            }
        }
        return -1;
    }

    @SuppressWarnings("ConstantConditions")
    public int primePalindromeBF(int N) {
        final int r = 2 * (int) 1e8;
        final TreeSet<Integer> palindromes = new TreeSet<>();
        dfs("", N, r, palindromes);
        for (int i = 0; i < 10; i++) {
            dfs(String.valueOf(i), N, r, palindromes);
        }
        for (int i = palindromes.ceiling(N); i <= palindromes.last(); i = palindromes.higher(i)) {
            if (isPrime(i)) {
                return i;
            }
        }
        return -1;
    }

    private static void dfs(String s, long l, long r, Set<Integer> res) {
        if (s.length() > 9) {
            return;
        }

        if (!s.isEmpty() && s.charAt(0) != 0) {
            final int num = Integer.parseInt(s);
            if (num > r) { return; }
            if (num >= l && isPalindrome(String.valueOf(num))) {
                res.add(num);
            }
        }

        for (int i = 0; i < 10; i++) {
            dfs(i + s + i, l, r, res);
        }
    }

    private static boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return num > 1;
    }
}
