package weekly_contests.weekly_7;

public class P_409 {

    public int longestPalindrome(String s) {
        final int[] map = new int[128];
        for (char c : s.toCharArray()) {
            map[c]++;
        }
        int res = 0;
        boolean odd = false;
        for (int num : map) {
            res += num;
            if (res % 2 != 0) {
                odd = true;
                res--;
            }
        }
        return res + (odd ? 1 : 0);
    }
}
