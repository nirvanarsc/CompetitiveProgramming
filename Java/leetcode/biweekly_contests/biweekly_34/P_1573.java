package leetcode.biweekly_contests.biweekly_34;

public class P_1573 {

    private static final int MOD = (int) (1e9 + 7);

    public int numWays(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c - '0';
        }
        if (sum % 3 != 0) {
            return 0;
        }
        if (sum == 0) {
            final long n = s.length() - 1;
            final long res = ((n * (n - 1)) / 2) % MOD;
            return (int) res;
        }
        final int target = sum / 3;
        int ll = -1;
        int lr = -1;
        int rl = -1;
        int rr = -1;
        int curr = 0;
        for (int i = 0; i < s.length(); i++) {
            curr += s.charAt(i) - '0';
            if (curr == target && ll == -1) {
                ll = i;
            }
            if (curr == target + 1 && lr == -1) {
                lr = i;
            }
            if (curr == 2 * target && rl == -1) {
                rl = i;
            }
            if (curr == (2 * target + 1) && rr == -1) {
                rr = i;
            }
        }
        final long l = (long) lr - ll;
        final long r = (long) rr - rl;
        return (int) ((l * r) % MOD);
    }
}
