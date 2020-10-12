package leetcode.weekly_contests.weekly_159;

public class P_1234 {

    public int balancedString(String s) {
        final int[] map = new int[128];
        final int n = s.length();
        final int k = n / 4;
        for (int j = 0; j < n; j++) {
            map[s.charAt(j)]++;
        }
        int i = 0;
        int res = n;
        for (int j = 0; j < n; j++) {
            map[s.charAt(j)]--;
            while (i < n && map['Q'] <= k && map['W'] <= k && map['E'] <= k && map['R'] <= k) {
                res = Math.min(res, j - i + 1);
                map[s.charAt(i++)]++;
            }
        }
        return res;
    }
}
