package leetcode.biweekly_contests.biweekly_0_99.biweekly_79;

public class P_1 {

    public boolean digitCount(String num) {
        final int[] f = new int[10];
        for (char c : num.toCharArray()) {
            f[c - '0']++;
        }
        for (int i = 0; i < num.length(); i++) {
            if (f[i] != num.charAt(i) - '0') {
                return false;
            }
        }
        return true;
    }
}
