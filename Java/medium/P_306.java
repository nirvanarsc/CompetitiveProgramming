package medium;

@SuppressWarnings("TailRecursion")
public class P_306 {

    public boolean isAdditiveNumber(String num) {
        return dfs(num.toCharArray(), 0, -1, -1, 0);
    }

    private static boolean dfs(char[] num, int idx, long prev, long prevprev, int len) {
        if (idx == num.length) {
            return len >= 3;
        }
        if (num[idx] == '0') {
            if (prev != -1 && prevprev != -1 && prev + prevprev != 0) {
                return false;
            }
            return dfs(num, idx + 1, 0, prev, len + 1);
        }
        long curr = 0;
        for (int i = idx; i < num.length; i++) {
            if (curr <= Long.MAX_VALUE / 10 + (num[i] - '0')) {
                curr = curr * 10 + (num[i] - '0');
                if (prev != -1 && prevprev != -1 && curr != prev + prevprev) {
                    continue;
                }
                if (dfs(num, i + 1, curr, prev, len + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
